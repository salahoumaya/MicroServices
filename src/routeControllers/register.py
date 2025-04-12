from flask import Blueprint, render_template, request, redirect, url_for, flash
from keycloak import KeycloakAdmin
from src.config.mongo import get_mongo_collection

registerPage = Blueprint("register", __name__, template_folder='templates')

# Configuration Keycloak Admin
keycloak_admin = KeycloakAdmin(
    server_url="http://localhost:8180/",
    username="admin",  
    password="admin",  
    realm_name="myorg",  
    user_realm_name="master", 
    client_id="admin-cli",
    verify=True
)

@registerPage.route("/register", methods=["GET", "POST"])
def register():
    if request.method == "POST":
        username = request.form["username"]
        email = request.form["email"]
        password = request.form["password"]
        role = request.form.get("role", "employee")  # "employee" par défaut

        # Vérifier si utilisateur existe déjà
        existing_users = keycloak_admin.get_users(query={"username": username})
        if existing_users:
            flash("⚠️ Nom d'utilisateur déjà pris.", "danger")
            return redirect(url_for("register.register"))

        # Créer l'utilisateur dans Keycloak
        user_id = keycloak_admin.create_user({
            "username": username,
            "email": email,
            "enabled": True,
            "firstName": username,
            "lastName": "Auto",
            "credentials": [{
                "value": password,
                "type": "password",
                "temporary": False
            }]
        })

        # Récupérer l'ID du client (flaskApp1)
        clients = keycloak_admin.get_clients()
        client = next((c for c in clients if c["clientId"] == "flaskApp1"), None)
        if not client:
            raise Exception("Client flaskApp1 not found in Keycloak")
        client_id = client["id"]

        # Assigner le rôle dynamique (employee ou admin)
        role_obj = keycloak_admin.get_client_role(client_id=client_id, role_name=role)
        keycloak_admin.assign_client_role(user_id=user_id, client_id=client_id, roles=[role_obj])

        # Enregistrer aussi l'utilisateur dans MongoDB
        users_collection = get_mongo_collection()
        users_collection.insert_one({
            "username": username,
            "email": email,
            "keycloak_id": user_id,
            "role": role
        })

        flash("✅ Compte créé avec succès ! Vous pouvez maintenant vous connecter.", "success")
        return redirect(url_for("oauth.login"))

    return render_template("register.html")
