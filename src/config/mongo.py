from pymongo import MongoClient

def get_mongo_collection():
    client = MongoClient("mongodb://localhost:27017/")
    db = client["flask_auth_db"]  # nom de ta base
    return db["users"]            # nom de ta collection
