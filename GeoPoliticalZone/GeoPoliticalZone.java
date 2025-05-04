package GeoPoliticalZone;

public enum GeoPoliticalZone {
    NORTH_CENTRAL("Benue", "FCT", "Kogi", "Kwara", "Narsarawa", "Niger", "plateau"),
    NORTH_EAST("Adamawa", "Bouchi", "Bornu", "Gombe", "Taraba", "Yobe"),
    NORTH_WEST("Kaduna","Kastina","Kano", "Kebbi", "Sokoto", "Jigawa", "Zamfarawa"),
    SOUTH_EAST("Abia", "Anambra", "Ebonyi", "Enugu", "Imo"),
    SOUTH_WEST("Ekiti", "Lagos", "Osun", "Ondo", "Ogun", "Oyo"),
    SOUTH_SOUTH("Akwa-ibom", "Bayelsa", "Cross-River", "Delta", "Edo","Rivers")
    ;


    private String[] states;
    GeoPoliticalZone(String... state) {
        this.states = state;
    }

    public String[] getState() {
        return states;
    }

     public static GeoPoliticalZone getGeoPoliticalZone(String state){
        for(GeoPoliticalZone geoPoliticalZone : GeoPoliticalZone.values()) {
            for (String region : geoPoliticalZone.states) {
                if (region.equalsIgnoreCase(state)) {

                    return geoPoliticalZone;
                }
            }
        }
        return null;
     }



}
