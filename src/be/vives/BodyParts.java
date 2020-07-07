package be.vives;

public enum BodyParts {
    HEAD("head"), BODY("body"), LEGS("legs"), ARMS("arms"), RHAND("rightHand"), LHAND("leftHand"), FEET("feet");

    String bodypart;
    BodyParts(String b) {bodypart = b;}
}
