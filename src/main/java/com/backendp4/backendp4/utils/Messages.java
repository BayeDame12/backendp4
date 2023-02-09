package com.backendp4.backendp4.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Messages {

    TYPE_ACTION_CREATION("Création de demande"),
    TYPE_ACTION_CREATION_ET_VALIDER("Création et validation de demande"),
    TYPE_ACTION_VALIDER("Validation de la demande"),
    TYPE_ACTION_INVALIDER("Invalidation de la demande"),

    TYPE_ACTION_ARCHIVER("Archivage de la demande"),
    TYPE_ACTION_REOUVRIR("Réouverture de la demande"),
    TYPE_ACTION_OUVRIR("Ouverture de la demande"),
    TYPE_ACTION_OUVRIR_SUIVANT("Ouverture de la demande suivante"),
    TYPE_ACTION_ENREGISTRER("Enregistrement de la demande"),


    SMS_CREATION_DEMANDE_NOUVEL_ABONNEMENT("Bonjour, votre demande Nouvel Abonnement est en cours de traitement. Le numéro du sim est: "),
    SMS_CREATION_DEMANDE_IDENTIFICATION_SIM("Bonjour, votre demande Identification Sim est en cours de traitement."),
    SMS_CREATION_DEMANDE_SWAP_SIM("Bonjour, votre demande Changement Sim est en cours de traitement."),
    SMS_CREATION_DEMANDE_CESSION_ABONNEMENT("Bonjour, votre demande Cession Abonnement est en cours de traitement."),
    SMS_CREATION_DEMANDE_NOUVEL_COMPTE_OM("Bonjour, votre demande Nouvel Compte Orange Money est en cours de traitement."),
    SMS_CREATION_DEMANDE_UPDATE_GRADE_COMPTE_OM("Bonjour, votre demande de mise à jour du grade du Compte Orange Money est en cours de traitement."),
    SMS_CREATION_DEMANDE_UPDATE_INFO_COMPTE_OM("Bonjour, votre demande de mise à jour des infos du Compte Orange Money est en cours de traitement."),

    SMS_VENDEUR_VALIDATION_DEMANDE_NOUVEL_ABONNEMENT("Cher(e) partenaire, votre demande Nouvel Abonnement a été validée."),
    SMS_VENDEUR_VALIDATION_DEMANDE_IDENTIFICATION_SIM("Cher(e) partenaire, votre demande Identification Sim a été validée."),
    SMS_VENDEUR_VALIDATION_DEMANDE_SWAP_SIM("Cher(e) partenaire, votre demande Changement Sim a été validée."),
    SMS_VENDEUR_VALIDATION_DEMANDE_CESSION_ABONNEMENT("Cher(e) partenaire, votre demande Cession Abonnement a été validée."),
    SMS_VENDEUR_VALIDATION_DEMANDE_CREATION_NOUVEL_COMPTE_OM("Cher(e) partenaire, votre demande de création de nouvel compte OM a été validée."),
    SMS_VENDEUR_VALIDATION_DEMANDE_UPDATE_GRADE_COMPTE_OM("Cher(e) partenaire, votre demande de mise à jour du grade du compte OM a été validée."),
    SMS_VENDEUR_VALIDATION_DEMANDE_UPDATE_INFO_COMPTE_OM("Cher(e) partenaire, votre demande de mise à jour des infos du compte OM a été validée."),

    SMS_ABONNE_VALIDATION_DEMANDE_NOUVEL_ABONNEMENT("Cher(e) abonne(e), votre demande Nouvel Abonnement a été validée. Le numéro du sim est: "),
    SMS_ABONNE_VALIDATION_DEMANDE_IDENTIFICATION_SIM("Cher(e) abonne(e), votre demande Identification Sim a été validée. Le numéro du sim est: "),
    SMS_ABONNE_VALIDATION_DEMANDE_SWAP_SIM("Cher(e) abonne(e), votre demande Changement Sim a été validée. Le numéro du sim est: "),
    SMS_ABONNE_VALIDATION_DEMANDE_CESSION_ABONNEMENT("Cher(e) abonne(e), votre demande Cession Abonnement a été validée. Le numéro du sim est: "),
    SMS_ABONNE_VALIDATION_DEMANDE_CREATION_NOUVEL_COMPTE_OM("Cher(e) abonne(e), votre demande de création de nouvel compte OM a été validée. Le numéro du sim est: "),
    SMS_ABONNE_VALIDATION_DEMANDE_UPDATE_GRADE_COMPTE_OM("Cher(e) abonne(e), votre demande de mise à jour du grade du compte OM a été validée. Le numéro du sim est: "),
    SMS_ABONNE_VALIDATION_DEMANDE_UPDATE_INFO_COMPTE_OM("Cher(e) abonne(e), votre demande de mise à jour des infos du compte OM a été validée. Le numéro du sim est: "),

    SMS_CREATION_DEMANDE_PARCOURS_UNIFIE_OM_NFC("Bonjour, votre demande Nouvel Compte Orange Money est créé et déplafonné avec succès. Le numéro du sim est: "),

    SMS_ABONNE_ALREADY_DEMANDE_CREATION_NOUVEL_COMPTE_OM("Cher(e) abonne(e), ce numéro a déjà un compte Orange Money."),
    SMS_ABONNE_ALREADY_UPDATE_GRADE_COMPTE_OM("Cher(e) abonne(e), ce numéro est déjà un compte Orange Money déplafonné."),
    SMS_ABONNE_ECHEC_CREATION_COMPTE_OM("Echec de création du compte Orange Money."),

    SMS_VENDEUR_INVALIDATION_DEMANDE_NOUVEL_ABONNEMENT("Cher(e) partenaire, votre demande Nouvel Abonnement a été rejetée."),
    SMS_VENDEUR_INVALIDATION_DEMANDE_IDENTIFICATION_SIM("Cher(e) partenaire, votre demande Identification Sim a été rejetée."),
    SMS_VENDEUR_INVALIDATION_DEMANDE_SWAP_SIM("Cher(e) partenaire, votre demande Changement Sim a été rejetée."),
    SMS_VENDEUR_INVALIDATION_DEMANDE_CESSION_ABONNEMENT("Cher(e) partenaire, votre demande Cession Abonnement a été rejetée."),
    SMS_VENDEUR_INVALIDATION_DEMANDE_CREATION_NOUVEL_COMPTE_OM("Cher(e) partenaire, votre demande de création de nouvel compte OM a été rejetée."),
    SMS_VENDEUR_INVALIDATION_DEMANDE_UPDATE_GRADE_COMPTE_OM("Cher(e) partenaire, votre demande de mise à jour du grade du compte OM a été rejetée."),
    SMS_VENDEUR_INVALIDATION_DEMANDE_UPDATE_INFO_COMPTE_OM("Cher(e) partenaire, votre demande de mise à jour des infos du compte OM a été rejetée."),

    SMS_ABONNE_INVALIDATION_DEMANDE_NOUVEL_ABONNEMENT("Cher(e) abonne(e), votre demande Nouvel Abonnement a été rejetée."),
    SMS_ABONNE_INVALIDATION_DEMANDE_IDENTIFICATION_SIM("Cher(e) abonne(e), votre demande Identification Sim a été rejetée."),
    SMS_ABONNE_INVALIDATION_DEMANDE_SWAP_SIM("Cher(e) abonne(e), votre demande Changement Sim a été rejetée."),
    SMS_ABONNE_INVALIDATION_DEMANDE_CESSION_ABONNEMENT("Cher(e) abonne(e), votre demande Cession Abonnement a été rejetée."),
    SMS_ABONNE_INVALIDATION_DEMANDE_CREATION_NOUVEL_COMPTE_OM("Cher(e) abonne(e), votre demande de création de nouvel compte OM a été rejetée."),
    SMS_ABONNE_INVALIDATION_DEMANDE_UPDATE_GRADE_COMPTE_OM("Cher(e) abonne(e), votre demande de mise à jour du grade du compte OM a été rejetée."),
    SMS_ABONNE_INVALIDATION_DEMANDE_UPDATE_INFO_COMPTE_OM("Cher(e) abonne(e), votre demande de mise à jour des infos du compte OM a été rejetée.");


    private final String value;


}
