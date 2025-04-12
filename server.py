from flask import Flask, render_template
from src.security.decorators import login_required
from src.routeControllers.oauth import oauthPage, initOauthClient
from src.config.appConfig import loadAppConfig
from src.routeControllers.register import registerPage
import py_eureka_client.eureka_client as eureka_client

# Charger la config
appConfig = loadAppConfig()

# Initialiser le client OAuth (Keycloak)
initOauthClient()

# Initialiser Flask
app = Flask(__name__)
app.secret_key = appConfig.flaskSecret

# Enregistrer les routes OAuth et Register
app.register_blueprint(registerPage, url_prefix="/")
app.register_blueprint(oauthPage, url_prefix="/oauth")

# Page d'accueil
@app.route('/')
def index():
    return render_template("home.html")

# Profil utilisateur connecté
@app.route('/profile')
@login_required
def profile():
    return render_template("profile.html")

# Dashboard des employés
@app.route('/employee-dashboard')
@login_required(roles=["employee"])
def employee_dashboard():
    return render_template("employee.html")

# Lancer l'enregistrement Eureka AVANT app.run
eureka_client.init(
    eureka_server="http://localhost:8761/eureka/",  # URL de ton Eureka Server
    app_name="flask-auth-service",                  # Nom du service côté Eureka
    instance_port=50100                             # Le port utilisé par Flask
)

# Lancer l'application
if __name__ == '__main__':
    app.run(host="0.0.0.0", port=50100, debug=True)
