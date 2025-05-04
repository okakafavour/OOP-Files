package Problem;

public class Problem {
    private String name;
    private String type;
    private boolean isSolved;

    private static final String[] VALID_TYPES = {
            "FINANCIAL", "SPIRITUAL", "EDUCATION", "BUSINESS", "TECHNICAL"
    };


    public Problem(String name, String type) {
        this.name = name;
        setType(type);
        this.isSolved = false;
    }


    public String getName() {
        return name;
    }

    //public void setName(String name) {
    //  this.name = name;
    //}

    //public String getDescription() {
    //     return description;
    //   }
    public String getType() {
        return type;
    }

    public void setType(String type) {

        if (type == null) {
            throw new IllegalArgumentException("Problem type cannot be null. Must be one of: FINANCIAL, SPIRITUAL, EDUCATION, BUSINESS, TECHNICAL");
        }

        for (String validType : VALID_TYPES) {
            if (validType.equalsIgnoreCase(type)) {
                this.type = validType;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid problem type: " + type + ". Must be one of: FINANCIAL, SPIRITUAL, EDUCATION, BUSINESS, TECHNICAL");
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        this.isSolved = solved;
    }


    public static String[] getValidTypes() {
        return VALID_TYPES;
    }
}