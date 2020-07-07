package be.vives;

public enum ItemType {
    STAFF("staff"), LSWORD("Longsword"), AXE("battle axe"), DAGGER("dagger"), WHIP("whip"), GUN("gun"), WAND("wand");

    String weapontype;
    ItemType(String b) {weapontype = b;}
}
