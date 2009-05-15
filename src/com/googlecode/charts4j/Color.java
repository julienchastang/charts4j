/**
 *
 * The MIT License
 *
 * Copyright (c) 2008 the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.googlecode.charts4j;

import static com.googlecode.charts4j.collect.Preconditions.*;


/**
 * RGB Color for all charts. There are many predefined colors defined herein
 * (e.g. Color.AQUA). You can also construct a color with the usual hexdecimal
 * notation (e.g. F0F8FF). You can also set the opacity.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class Color {

    /** ALICEBLUE. */
    public static final Color ALICEBLUE            = new Color("F0F8FF");

    /** ANTIQUEWHITE. */
    public static final Color ANTIQUEWHITE         = new Color("FAEBD7");

    /** AQUA. */
    public static final Color AQUA                 = new Color("00FFFF");

    /** AQUAMARINE. */
    public static final Color AQUAMARINE           = new Color("7FFFD4");

    /** AZURE. */
    public static final Color AZURE                = new Color("F0FFFF");

    /** BEIGE. */
    public static final Color BEIGE                = new Color("F5F5DC");

    /** BISQUE. */
    public static final Color BISQUE               = new Color("FFE4C4");

    /** BLACK. */
    public static final Color BLACK                = new Color("000000");

    /** BLANCHEDALMOND. */
    public static final Color BLANCHEDALMOND       = new Color("FFEBCD");

    /** BLUE. */
    public static final Color BLUE                 = new Color("0000FF");

    /** BLUEVIOLET. */
    public static final Color BLUEVIOLET           = new Color("8A2BE2");

    /** BROWN. */
    public static final Color BROWN                = new Color("A52A2A");

    /** BURLYWOOD. */
    public static final Color BURLYWOOD            = new Color("DEB887");

    /** CADETBLUE. */
    public static final Color CADETBLUE            = new Color("5F9EA0");

    /** CHARTREUSE. */
    public static final Color CHARTREUSE           = new Color("7FFF00");

    /** CHOCOLATE. */
    public static final Color CHOCOLATE            = new Color("D2691E");

    /** CORAL. */
    public static final Color CORAL                = new Color("FF7F50");

    /** CORNFLOWERBLUE. */
    public static final Color CORNFLOWERBLUE       = new Color("6495ED");

    /** CORNSILK. */
    public static final Color CORNSILK             = new Color("FFF8DC");

    /** CRIMSON. */
    public static final Color CRIMSON              = new Color("DC143C");

    /** CYAN. */
    public static final Color CYAN                 = new Color("00FFFF");

    /** DARKBLUE. */
    public static final Color DARKBLUE             = new Color("00008B");

    /** DARKCYAN. */
    public static final Color DARKCYAN             = new Color("008B8B");

    /** DARKGOLDENROD. */
    public static final Color DARKGOLDENROD        = new Color("B8860B");

    /** DARKGRAY. */
    public static final Color DARKGRAY             = new Color("A9A9A9");

    /** DARKGREEN. */
    public static final Color DARKGREEN            = new Color("006400");

    /** DARKKHAKI. */
    public static final Color DARKKHAKI            = new Color("BDB76B");

    /** DARKMAGENTA. */
    public static final Color DARKMAGENTA          = new Color("8B008B");

    /** DARKOLIVEGREEN. */
    public static final Color DARKOLIVEGREEN       = new Color("556B2F");

    /** DARKORANGE. */
    public static final Color DARKORANGE           = new Color("FF8C00");

    /** DARKORCHID. */
    public static final Color DARKORCHID           = new Color("9932CC");

    /** DARKRED. */
    public static final Color DARKRED              = new Color("8B0000");

    /** DARKSALMON. */
    public static final Color DARKSALMON           = new Color("E9967A");

    /** DARKSEAGREEN. */
    public static final Color DARKSEAGREEN         = new Color("8FBC8F");

    /** DARKSLATEBLUE. */
    public static final Color DARKSLATEBLUE        = new Color("483D8B");

    /** DARKSLATEGRAY. */
    public static final Color DARKSLATEGRAY        = new Color("2F4F4F");

    /** DARKTURQUOISE. */
    public static final Color DARKTURQUOISE        = new Color("00CED1");

    /** DARKVIOLET. */
    public static final Color DARKVIOLET           = new Color("9400D3");

    /** DEEPPINK. */
    public static final Color DEEPPINK             = new Color("FF1493");

    /** DEEPSKYBLUE. */
    public static final Color DEEPSKYBLUE          = new Color("00BFFF");

    /** DIMGRAY. */
    public static final Color DIMGRAY              = new Color("696969");

    /** DODGERBLUE. */
    public static final Color DODGERBLUE           = new Color("1E90FF");

    /** FIREBRICK. */
    public static final Color FIREBRICK            = new Color("B22222");

    /** FLORALWHITE. */
    public static final Color FLORALWHITE          = new Color("FFFAF0");

    /** FORESTGREEN. */
    public static final Color FORESTGREEN          = new Color("228B22");

    /** FUCHSIA. */
    public static final Color FUCHSIA              = new Color("FF00FF");

    /** GAINSBORO. */
    public static final Color GAINSBORO            = new Color("DCDCDC");

    /** GHOSTWHITE. */
    public static final Color GHOSTWHITE           = new Color("F8F8FF");

    /** GOLD. */
    public static final Color GOLD                 = new Color("FFD700");

    /** GOLDENROD. */
    public static final Color GOLDENROD            = new Color("DAA520");

    /** GRAY. */
    public static final Color GRAY                 = new Color("808080");

    /** GREEN. */
    public static final Color GREEN                = new Color("008000");

    /** GREENYELLOW. */
    public static final Color GREENYELLOW          = new Color("ADFF2F");

    /** HONEYDEW. */
    public static final Color HONEYDEW             = new Color("F0FFF0");

    /** HOTPINK. */
    public static final Color HOTPINK              = new Color("FF69B4");

    /** INDIANRED. */
    public static final Color INDIANRED            = new Color("CD5C5C");

    /** INDIGO. */
    public static final Color INDIGO               = new Color("4B0082");

    /** IVORY. */
    public static final Color IVORY                = new Color("FFFFF0");

    /** KHAKI. */
    public static final Color KHAKI                = new Color("F0E68C");

    /** LAVENDER. */
    public static final Color LAVENDER             = new Color("E6E6FA");

    /** LAVENDERBLUSH. */
    public static final Color LAVENDERBLUSH        = new Color("FFF0F5");

    /** LAWNGREEN. */
    public static final Color LAWNGREEN            = new Color("7CFC00");

    /** LEMONCHIFFON. */
    public static final Color LEMONCHIFFON         = new Color("FFFACD");

    /** LIGHTBLUE. */
    public static final Color LIGHTBLUE            = new Color("ADD8E6");

    /** LIGHTCORAL. */
    public static final Color LIGHTCORAL           = new Color("F08080");

    /** LIGHTCYAN. */
    public static final Color LIGHTCYAN            = new Color("E0FFFF");

    /** LIGHTGOLDENRODYELLOW. */
    public static final Color LIGHTGOLDENRODYELLOW = new Color("FAFAD2");

    /** LIGHTGREEN. */
    public static final Color LIGHTGREEN           = new Color("90EE90");

    /** LIGHTGREY. */
    public static final Color LIGHTGREY            = new Color("D3D3D3");

    /** LIGHTPINK. */
    public static final Color LIGHTPINK            = new Color("FFB6C1");

    /** LIGHTSALMON. */
    public static final Color LIGHTSALMON          = new Color("FFA07A");

    /** LIGHTSEAGREEN. */
    public static final Color LIGHTSEAGREEN        = new Color("20B2AA");

    /** LIGHTSKYBLUE. */
    public static final Color LIGHTSKYBLUE         = new Color("87CEFA");

    /** LIGHTSLATEGRAY. */
    public static final Color LIGHTSLATEGRAY       = new Color("778899");

    /** LIGHTSTEELBLUE. */
    public static final Color LIGHTSTEELBLUE       = new Color("B0C4DE");

    /** LIGHTYELLOW. */
    public static final Color LIGHTYELLOW          = new Color("FFFFE0");

    /** LIME. */
    public static final Color LIME                 = new Color("00FF00");

    /** LIMEGREEN. */
    public static final Color LIMEGREEN            = new Color("32CD32");

    /** LINEN. */
    public static final Color LINEN                = new Color("FAF0E6");

    /** MAGENTA. */
    public static final Color MAGENTA              = new Color("FF00FF");

    /** MAROON. */
    public static final Color MAROON               = new Color("800000");

    /** MEDIUMAQUAMARINE. */
    public static final Color MEDIUMAQUAMARINE     = new Color("66CDAA");

    /** MEDIUMBLUE. */
    public static final Color MEDIUMBLUE           = new Color("0000CD");

    /** MEDIUMORCHID. */
    public static final Color MEDIUMORCHID         = new Color("BA55D3");

    /** MEDIUMPURPLE. */
    public static final Color MEDIUMPURPLE         = new Color("9370DB");

    /** MEDIUMSEAGREEN. */
    public static final Color MEDIUMSEAGREEN       = new Color("3CB371");

    /** MEDIUMSLATEBLUE. */
    public static final Color MEDIUMSLATEBLUE      = new Color("7B68EE");

    /** MEDIUMSPRINGGREEN. */
    public static final Color MEDIUMSPRINGGREEN    = new Color("00FA9A");

    /** MEDIUMTURQUOISE. */
    public static final Color MEDIUMTURQUOISE      = new Color("48D1CC");

    /** MEDIUMVIOLETRED. */
    public static final Color MEDIUMVIOLETRED      = new Color("C71585");

    /** MIDNIGHTBLUE. */
    public static final Color MIDNIGHTBLUE         = new Color("191970");

    /** MINTCREAM. */
    public static final Color MINTCREAM            = new Color("F5FFFA");

    /** MISTYROSE. */
    public static final Color MISTYROSE            = new Color("FFE4E1");

    /** MOCCASIN. */
    public static final Color MOCCASIN             = new Color("FFE4B5");

    /** NAVAJOWHITE. */
    public static final Color NAVAJOWHITE          = new Color("FFDEAD");

    /** NAVY. */
    public static final Color NAVY                 = new Color("000080");

    /** OLDLACE. */
    public static final Color OLDLACE              = new Color("FDF5E6");

    /** OLIVE. */
    public static final Color OLIVE                = new Color("808000");

    /** OLIVEDRAB. */
    public static final Color OLIVEDRAB            = new Color("6B8E23");

    /** ORANGE. */
    public static final Color ORANGE               = new Color("FFA500");

    /** ORANGERED. */
    public static final Color ORANGERED            = new Color("FF4500");

    /** ORCHID. */
    public static final Color ORCHID               = new Color("DA70D6");

    /** PALEGOLDENROD. */
    public static final Color PALEGOLDENROD        = new Color("EEE8AA");

    /** PALEGREEN. */
    public static final Color PALEGREEN            = new Color("98FB98");

    /** PALETURQUOISE. */
    public static final Color PALETURQUOISE        = new Color("AFEEEE");

    /** PALEVIOLETRED. */
    public static final Color PALEVIOLETRED        = new Color("DB7093");

    /** PAPAYAWHIP. */
    public static final Color PAPAYAWHIP           = new Color("FFEFD5");

    /** PEACHPUFF. */
    public static final Color PEACHPUFF            = new Color("FFDAB9");

    /** PERU. */
    public static final Color PERU                 = new Color("CD853F");

    /** PINK. */
    public static final Color PINK                 = new Color("FFC0CB");

    /** PLUM. */
    public static final Color PLUM                 = new Color("DDA0DD");

    /** POWDERBLUE. */
    public static final Color POWDERBLUE           = new Color("B0E0E6");

    /** PURPLE. */
    public static final Color PURPLE               = new Color("800080");

    /** RED. */
    public static final Color RED                  = new Color("FF0000");

    /** ROSYBROWN. */
    public static final Color ROSYBROWN            = new Color("BC8F8F");

    /** ROYALBLUE. */
    public static final Color ROYALBLUE            = new Color("4169E1");

    /** SADDLEBROWN. */
    public static final Color SADDLEBROWN          = new Color("8B4513");

    /** SALMON. */
    public static final Color SALMON               = new Color("FA8072");

    /** SANDYBROWN. */
    public static final Color SANDYBROWN           = new Color("F4A460");

    /** SEAGREEN. */
    public static final Color SEAGREEN             = new Color("2E8B57");

    /** SEASHELL. */
    public static final Color SEASHELL             = new Color("FFF5EE");

    /** SIENNA. */
    public static final Color SIENNA               = new Color("A0522D");

    /** SILVER. */
    public static final Color SILVER               = new Color("C0C0C0");

    /** SKYBLUE. */
    public static final Color SKYBLUE              = new Color("87CEEB");

    /** SLATEBLUE. */
    public static final Color SLATEBLUE            = new Color("6A5ACD");

    /** SLATEGRAY. */
    public static final Color SLATEGRAY            = new Color("708090");

    /** SNOW. */
    public static final Color SNOW                 = new Color("FFFAFA");

    /** SPRINGGREEN. */
    public static final Color SPRINGGREEN          = new Color("00FF7F");

    /** STEELBLUE. */
    public static final Color STEELBLUE            = new Color("4682B4");

    /** TAN. */
    public static final Color TAN                  = new Color("D2B48C");

    /** TEAL. */
    public static final Color TEAL                 = new Color("008080");

    /** THISTLE. */
    public static final Color THISTLE              = new Color("D8BFD8");

    /** TOMATO. */
    public static final Color TOMATO               = new Color("FF6347");

    /** TURQUOISE. */
    public static final Color TURQUOISE            = new Color("40E0D0");

    /** VIOLET. */
    public static final Color VIOLET               = new Color("EE82EE");

    /** WHEAT. */
    public static final Color WHEAT                = new Color("F5DEB3");

    /** WHITE. */
    public static final Color WHITE                = new Color("FFFFFF");

    /** WHITESMOKE. */
    public static final Color WHITESMOKE           = new Color("F5F5F5");

    /** YELLOW. */
    public static final Color YELLOW               = new Color("FFFF00");

    /** YELLOWGREEN. */
    public static final Color YELLOWGREEN          = new Color("9ACD32");

    /** Max opacity. **/
    private static final int  MAX_OPACITY          = 100;

    /** Min opacity. **/
    private static final int  MIN_OPACITY          = 0;

    /** Color string hex. **/
    private final String      color;

    /** Opacity string hex. **/
    private final String      opacity;

    /**
     * The Constructor.
     *
     * @param color
     *            the color
     *
     * @see #newColor(String)
     */
    Color(final String color) {
        checkNotNull(color, "color cannot be null.");
        this.color = validateColor(color);
        opacity = "FF";
    }

    /**
     * The Constructor.
     *
     * @param color
     *            the color
     * @param opacity
     *            the opacity
     *
     * @see #newColor(String, int)
     */
    Color(final String color, final int opacity) {
        checkNotNull(color, "color cannot be null.");
        this.color = validateColor(color);
        this.opacity = validateOpacity(opacity);
    }

    /**
     * The Constructor.
     *
     * @param color
     *            the color
     * @param opacity
     *            the opacity
     *
     * @see #newColor(Color, int)
     */
    Color(final Color color, final int opacity) {
        checkNotNull(color, "color cannot be null.");
        this.color = color.toString().substring(0, 6);
        this.opacity = validateOpacity(opacity);
    }

    /**
     * Method to validate color.
     *
     * @param color
     *            Color to validate
     *
     * @return Validated RGB color string.
     */
    private String validateColor(final String color) {
        int colorInt;
        try {
            colorInt = Integer.parseInt(color, 16);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(color + " is not a valid color.");
        }
        // Bit shifting 3 bytes should yield 0 for rgb colors.
        checkArgument((colorInt >> 24) == 0, "%s is not a valid color.", color);
        checkArgument(color.length() == 6, "%s is not a valid color. (Must be 6 charcters long).", color);
        // GWT doesnt support Locale.*
        return color.toUpperCase();
    }

    /**
     * Method to validate opacity.
     *
     * @param opacityInt
     *            opacity to validate
     *
     * @return opacity expressed as a hexadecimal
     */
    private String validateOpacity(final int opacityInt) {
        checkArgument((opacityInt >= MIN_OPACITY && opacityInt <= MAX_OPACITY), "%s is not a valid opacity.", opacityInt);
        // GWT doesnt support Locale.*
        final String s = Integer.toHexString((int) (opacityInt / 100d * (0xff))).toUpperCase();
        return (s.length() == 1) ? "0" + s : s;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return color + ((!"FF".equals(opacity)) ? opacity : "");
    }

    /**
     * Pass in an RGB color string from 000000 to FFFFFF.
     *
     * @param color
     *            RGB color in hexidecimal. Cannot be null.
     *
     * @return a newly constructed color.
     */
    public static Color newColor(final String color) {
        return new Color(color);
    }

    /**
     * Pass in an RGB color string from 000000 to FFFFFF
     *
     * You can also specify transparency by supplying a value between 0 and 100
     * where 0 is completely transparent and 100 completely opaque.
     *
     * @param color
     *            RGB color in hexidecimal. Cannot be null.
     * @param opacity
     *            Supply a number between 0 and 100. 0 is completely
     *            transparent, and 100 is completely opaque.
     *
     * @return a newly constructed color
     */
    public static Color newColor(final String color, final int opacity) {
        return new Color(color, opacity);
    }

    /**
     * Construct a color by passing in a color constant (e.g. Color.Blue) and an
     * opacity.
     *
     * @param color
     *            Color constant (ex: Color.Blue)
     * @param opacity
     *            Supply a number between 0 and 100. 0 is completely
     *            transparent, and 100 is completely opaque.
     *
     * @return a newly constructed color
     */
    public static Color newColor(final Color color, final int opacity) {
        return new Color(color, opacity);
    }
}
