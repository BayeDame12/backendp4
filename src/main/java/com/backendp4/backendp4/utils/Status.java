package com.backendp4.backendp4.utils;

public enum Status {

    OK(200, "SUCCESS"),
    KO(400, "Echec"),

    KO_CHANGE_NEW_PASS(400, "Merci d'utiliser votre accés dédié"),

    UNAUTHORIZED(401, "Vous n'etes pas autorisé à acceder"),
    BAD_REQUEST(400, "Données incorrectes"),
    NOT_VALID_REQUEST(422, "Erreur. Parametres invalides"),

    ALDREADY_LINK_PROFIL_USER(400, "Ce profil est déjà lié à un utiliseur"),
    ALDREADY_LINK_ROLE_USER(400, "Ce role est déjà lié à un utiliseur"),
    ALDREADY_LINK_ROLE_PROFIL(400, "Ce role est déjà lié à un profil utiliseur"),
    ALDREADY_LINK_OPERATION_PROFIL(400, "Cette opération est déjà lié à un profil"),
    ALREADY_USE_USERNAME(422, "Ce login est déjà utilisé"),
    ALREADY_USE_EMAIL(422, "Email déjà utilisé"),
    ALREADY_USE_TELEPHONE(422, "Téléphone déjà utilisé"),
    ALREADY_LDAP_USERNAME(422, "Ce login est déjà utilisé sur LDAP"),

    NOT_FOUND_USER(404, "L'utilisateur n'existe pas"),
    NOT_FOUND_OTHER_USER(404, "L'agent n'existe pas"),

    NOT_FOUND_DEMANDE(404, "La demande n'existe pas"),
    NOT_FOUND_ROLE(404, "Le role n'existe pas"),
    NOT_FOUND_OPERATION(404, "L'opération n'existe pas"),
    NOT_FOUND_PROFIL(404, "Le profil n'existe pas"),
    NOT_FOUND_MOTIF(404, "Le motif n'existe pas"),
    NOT_FOUND_TYPE_COMMENTAIRE(404, "Le type de commentaire n'existe pas"),
    NOT_FOUND_ETAT_DEMANDE(404, "L'état de la demande n'existe pas"),
    NOT_FOUND_VERSIONNING(404, "Le versionning n'existe pas"),

    OK_CHANGE_PIN(200, "Pin changé avec succès"),
    NOT_CHAGE_NEW_PIN(404, "Veuillez changer ce nouveau pin"),

    NOT_CHAGE_NEW_PASS(404, "Veuillez changer ce nouveau mot de passe"),

    OK_VALID_PIN(200, "Pin valide"),
    NOT_VALID_PIN(404, "Pin invalide. Veuillez réessayer"),

    KO_LOGIN(404, "Login ou mot de passe incorrect"),
    KO_COMPTE_DESACTIVER(404, "Ce compte a été désactivé"),
    KO_COMPTE_SUSPENDU(404, "Ce compte a été suspendu"),
    KO_COMPTE_CLOTURER(404, "Ce compte a été cloturé"),
    OK_REINITIALISATION_PIN(200, "Pin réinitialisé avec succès"),
    OK_REINITIALISATION_PASS(200, "Mot de passe réinitialisé avec succès"),

    BAD_REQUEST_TYPE_PIECE(404, "Erreur : type de pièce incorrect."),
    BAD_REQUEST_NATIONALITE(404, "Erreur : la nationalité n'est pas sur la liste disponible."),

    NOT_FOUND_VERIFICATION_IMSI(404, "Le IMSI n'est pas disponible"),
    NOT_FOR_AGENT_VERIFICATION_IMSI(404, "L'IMSI n'est pas dans tes stocks"),
    NOT_FOUND_API_MANAGEMENT_RELATEDPARTY_OR_LOGIN(404, "Erreur serveur API-MANAGEMENT: Le champ relatedParty est null ou Le champ login est null"),

    OK_VALID_OTP(200, "L'OTP est valide"),
    NOT_VALID_OTP(404, "L'OTP n'est pas valide"),
    EXPIRE_OTP(404, "L'OTP est expiré"),
    KO_AGE_MINIMAL(404, "Moins de 13 ages"),

    NOT_FOUND_VERIFICATION_ABONNE_KIKANELA(404, "Numéro piece ne correspond pas au nom ou prénom saisi"),
    NOT_FOUND_VERIFICATION_ABONNE_SAMECNI(404, "Nombre d'abonnement maximal autorisé est atteint"),
    OK_VERIFICATION_INFO_MSISDN(200, "Ce numéro peut etre identifié"),
    OK_VERIFICATION_INFO_MSISDN_SWAPPABLE(200, "Ce numero peut fait l'objet de changement de SIM"),
    OK_VERIFICATION_INFO_MSISDN_CESSION(200, "Ce numero ne peut fait l'objet de changement de Cession"),
    NOT_FOUND_VERIFICATION_INFO_MSISDN(404, "Ce numéro ne peut pas etre identifié"),
    NOT_FOUND_VERIFICATION_INFO_MSISDN_SWAPPABLE(404, "Ce numero ne peut fait l'objet de changement de SIM"),
    NOT_FOUND_VERIFICATION_INFO_MSISDN_CESSION(404, "Ce numero ne peut fait l'objet de changement de Cession"),
    NOT_FOUND_MSISDN(404, "Ce numéro n'existe pas dans la base"),
    NOT_MSISDN(404, "Le numéro ne doit pas etre vide"),
    NOT_FOUND_VERIFICATION_INFO_MSISDN_REGISTRATION_STATUS(404, "Erreur serveur API-MANAGEMENT: Le champ registrationStatus est null"),

    NOT_FOUND_API_MANAGEMENT_1(404, "Erreur serveur API-MANAGEMENT (1)"),
    NOT_FOUND_API_MANAGEMENT_2(404, "Erreur serveur API-MANAGEMENT (2)"),
    NOT_FOUND_API_MANAGEMENT_3(404, "Erreur serveur API-MANAGEMENT (3)"),
    NOT_FOUND_API_MANAGEMENT_4(404, "Erreur serveur API-MANAGEMENT (4)"),
    NOT_FOUND_API_MANAGEMENT_5(404, "Erreur serveur API-MANAGEMENT (5)"),
    NOT_FOUND_API_MANAGEMENT_6(404, "Erreur serveur API-MANAGEMENT (6)"),
    NOT_FOUND_API_MANAGEMENT_7(404, "Erreur serveur API-MANAGEMENT (7)"),
    NOT_FOUND_API_MANAGEMENT_8(404, "Erreur serveur API-MANAGEMENT (8)"),
    NOT_FOUND_API_MANAGEMENT_9(404, "Erreur serveur API-MANAGEMENT (9)"),
    NOT_FOUND_API_MANAGEMENT_10(404, "Erreur serveur externe (10)"),

    KO_BROKEN(101, "L'initiateur n'est pas valide"),
    NOT_BROKEN_CLIENT(404, "Le client n'est pas identifié"),
    NOT_FOUND_API_BROKER_OM_FORMAT(404, "Format response incorrect"),
    NOT_FOUND_API_BROKER_OM_1(404, "Erreur serveur API-BROKER-OM (1)"),
    NOT_FOUND_API_BROKER_OM_2(404, "Erreur serveur API-BROKER-OM (2)"),

    OK_DEMANDE_NA(200, "La demande de nouvel abonnement est créée avec succès"),
    OK_DEMANDE_IDENTIFICATION(200, "La demande d'identification est créée avec succès"),
    OK_DEMANDE_SIMSWAP(200, "La demande de Simswap est créée avec succès"),
    OK_DEMANDE_CESSIONABONNEMENT(200, "La demande  de cession d'abonnement est créée avec succès"),
    OK_DEMANDE_NCOM(200, "La demande de création du compte OM est créée avec succès"),
    OK_DEMANDE_UGCOM(200, "La demande de mise a jour grade du compte OM est créée avec succès"),
    OK_DEMANDE_UICOM(200, "La demande de mise à jour des info du compte OM est créée avec succès"),

    OK_UPLOAD_IMAGE_DEMANDE(200, "Les images de la demande ont été uploadées avec succès"),
    NOT_FOUND_IMAGE(404, "La photo de la demande n'existe pas"),
    NOT_FOUND_FILE(404, "Le fichier n'est pas disponible."),

    OK_VALIDATION_DEMANDE_NA(200, "La demande de nouvel abonnement a été validé avec succès"),
    OK_VALIDATION_DEMANDE_IDENTIFICATION(200, "La demande d'identification a été validé avec succès"),
    OK_VALIDATION_DEMANDE_SIMSWAP(200, "La demande de simswap a été validé avec succès"),
    OK_VALIDATION_DEMANDE_CESSIONABONNEMENT(200, "La demande de cession abonnement a été validé avec succès"),
    OK_VALIDATION_DEMANDE_NCOM(200, "La demande de création du compte OM a été validé avec succès"),
    OK_VALIDATION_DEMANDE_UGCOM(200, "La demande de mise a jour grade du compte OM a été validé avec succès"),
    OK_VALIDATION_DEMANDE_UICOM(200, "La demande de mise à jour des info du compte OM a été validé avec succès"),

    OK_INVALIDATION_DEMANDE_NA(200, "La demande de nouvel abonnement a été invalidé avec succès"),
    OK_INVALIDATION_DEMANDE_IDENTIFICATION(200, "La demande d'identification a été invalidé avec succès"),
    OK_INVALIDATION_DEMANDE_SIMSWAP(200, "La demande simswap a été invalidé avec succès"),
    OK_INVALIDATION_DEMANDE_CESSIONABONNEMENT(200, "La demande cession d'abonnement a été invalidé avec succès"),
    OK_INVALIDATION_DEMANDE_NCOM(200, "La demande de création de compte OM a été invalidé avec succès"),
    OK_INVALIDATION_DEMANDE_UGCOM(200, "La demande de mise a jour grade du compte OM a été invalidé avec succès"),
    OK_INVALIDATION_DEMANDE_UICOM(200, "La demande de mise à jour des info du compte OM a été invalidé avec succès"),

    NOT_FOUND_OUVRIR_DEMANDE_SUIVANTE(404, "Il n'y a plus de demande pour cet état"),

    ERREUR_INTERNE(404, "Erreur interne");


    private final Integer code;
    private final String message;


    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
