from urllib.parse import quote_plus, urlencode
from flask import Blueprint, redirect, url_for, current_app, session, abort
from src.config.appConfig import getAppConfig
from src.security.user import createUserSession, clearUserSession, getUserFromSession
from authlib.integrations.flask_client import OAuth

oauthPage = Blueprint('oauth', __name__,
                      template_folder='templates')

oauth = None


def initOauthClient():
    global oauth
    appConfig = getAppConfig()
    oauth = OAuth(current_app)
    oauth.register(
        "keycloak",
        client_id=appConfig.oauthAppClientId,
        client_secret=appConfig.oauthAppClientSecret,
        client_kwargs={
            "scope": "openid profile email roles",
            # 'code_challenge_method': 'S256'  # enable PKCE
        },
        server_metadata_url=appConfig.oauthProviderDiscoveryUrl,
    )


@oauthPage.route("/login")
def login():
    # check if session already present
    if "user" in session:
        abort(404)
    return oauth.keycloak.authorize_redirect(redirect_uri=url_for(".callback", _external=True))


@oauthPage.route("/login/callback")
def callback():
    tokenResponse = oauth.keycloak.authorize_access_token()
    idToken = tokenResponse["id_token"]
    userInfo = tokenResponse["userinfo"]
    # if roles are not included in id token, call user info endpoint explicitly 
    # userInfo = oauth.keycloak.userinfo()
    uRoles = []
    if oauth.keycloak.client_id in userInfo['resource_access']:
        uRoles = userInfo['resource_access'][oauth.keycloak.client_id]["roles"]
    if not (isinstance(uRoles, list)):
        uRoles = [uRoles]
    createUserSession(
        userId=userInfo["sub"], userName=userInfo["preferred_username"], email=userInfo["email"], roles=uRoles, idToken=idToken)
    return redirect('/')


@oauthPage.route("/logout")
def logout():
    user = getUserFromSession()
    idToken = user["idToken"] if user else None
    clearUserSession()

    # Forcer la déconnexion Keycloak avec redirection vers l'écran de login
    logout_url = oauth.keycloak.load_server_metadata().get('end_session_endpoint')
    
    return redirect(
        logout_url + "?" + urlencode({
            "post_logout_redirect_uri": url_for("oauth.login", _external=True),
            "id_token_hint": idToken
        }, quote_via=quote_plus)
    )
