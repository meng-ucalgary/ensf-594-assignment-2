/**
 * Provides ANSI colored output
 *
 * @author Bhavyai Gupta
 */
public class ColorText {
    private static String partOne;
    private static String partTwo;
    private static String partThree;
    private final static String RESET = "\033[0m";

    /**
     * Constructor is declared private to prevent instantiation of the class
     */
    private ColorText() {
    }

    /**
     * Returns the ANSI code of the foreground, regular {@link Color}
     *
     * @param color    of type {@link Color}
     * @param textmode of type {@link TextMode}
     * @return a string representing of the argument
     */
    private static String getANSI(Color color) {
        return getANSI(color, TextMode.NORMAL, false);
    }

    /**
     * Returns the ANSI code of the foreground {@link Color} with flag
     * {@link TextMode}
     *
     * @param color    of type {@link Color}
     * @param textmode of type {@link TextMode}
     * @return a string representing of the argument
     */
    private static String getANSI(Color color, TextMode textmode) {
        return getANSI(color, textmode, false);
    }

    /**
     * Returns the ANSI code of the foreground or background {@link Color} with flag
     * {@link TextMode}
     *
     * @param color      of type {@link Color}
     * @param textmode   of type {@link TextMode}
     * @param background {@code true} for background, {@code false} for foreground
     * @return a string representing of the argument
     */
    private static String getANSI(Color color, TextMode textmode, boolean background) {
        partOne = "\033[";
        partTwo = String.valueOf(textmode.getCode()) + ";";

        if (background == false) {
            partThree = String.valueOf(color.getCode()) + "m";
        }

        else {
            partThree = String.valueOf(color.getCode() + 10) + "m";
        }

        return (partOne + partTwo + partThree);
    }

    /**
     * Returns the colored text of string with the specified foreground
     * {@link Color}
     *
     * @param str   the string to be colored
     * @param color of type {@link Color}
     * @return a string representing of the argument
     */
    public static String text(String str, Color color) {
        String temp = String.format(getANSI(color) + str + RESET);
        return temp;
    }

    /**
     * Returns the colored text of string with the specified foreground
     * {@link Color} and flag {@link TextMode}
     *
     * @param str      the string to be colored
     * @param color    of type {@link Color}
     * @param textmode of type {@link TextMode}
     * @return a string representing of the argument
     */
    public static String text(String str, Color color, TextMode textmode) {
        String temp = String.format(getANSI(color, textmode) + str + RESET);
        // System.out.print(temp);
        return temp;
    }

    /**
     * Returns the colored text of string with specified {@link Color} with flag
     * {@link TextMode}, with the choice of foreground or background
     *
     * @param str        the string to be colored
     * @param color      of type {@link Color}
     * @param textmode   of type {@link TextMode}
     * @param background {@code true} for background, {@code false} for foreground
     * @return a string representing of the argument
     */
    public static String text(String str, Color color, TextMode textmode, boolean background) {
        String temp = String.format(getANSI(color, textmode, background) + str + RESET);
        // System.out.print(temp);
        return temp;
    }
}

/**
 * Enum Color to hold the partThree of the ANSI sequence
 */
enum Color {
    BLACK(30), RED(31), GREEN(32), YELLOW(33), BLUE(34), MAGENTA(35), CYAN(36), WHITE(37), GRAY(90), BRIGHT_RED(91),
    BRIGHT_GREEN(92), BRIGHT_YELLOW(93), BRIGHT_BLUE(94), BRIGHT_MAGENTA(95), BRIGHT_CYAN(96), BRIGHT_WHITE(97);

    private int c;

    Color(int x) {
        this.c = x;
    }

    int getCode() {
        return this.c;
    }
}

/**
 * Enum TextMode to hold the partTwo of the ANSI sequence
 */
enum TextMode {
    NORMAL(0), BOLD(1), FAINT(2), ITALICS(3), UNDERLINE(4), SLOWBLINK(5), RAPIDBLINK(6), REVERSE(7), HIDE(8),
    STRIKETHROUGH(9);

    private int c;

    TextMode(int x) {
        this.c = x;
    }

    int getCode() {
        return this.c;
    }
}
