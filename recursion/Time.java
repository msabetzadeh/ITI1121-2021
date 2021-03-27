class Time implements Comparable {

    // constants (final) class variables

    static public final int HOURS_PER_DAY      = 24;
    static public final int MINUTES_PER_HOUR   = 60;
    static public final int SECONDS_PER_MINUTE = 60;

    static public final int SECONDS_PER_HOUR   = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
    static public final int SECONDS_PER_DAY    = SECONDS_PER_HOUR * HOURS_PER_DAY;

    // instance variables

    private int timeInSeconds ; // 0 .. SECONDS_PER_DAY - 1 (inclusively)

    // constructor

    public Time (int hours, int minutes, int seconds) {
        timeInSeconds = (seconds + (minutes * SECONDS_PER_MINUTE) +
                         (hours * SECONDS_PER_HOUR)) % SECONDS_PER_DAY;
    }

    // getters

    public int getHours () {
        return timeInSeconds / SECONDS_PER_HOUR;
    }

    public int getMinutes () {
        return (timeInSeconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
    }

    public int getSeconds () {
        return timeInSeconds % SECONDS_PER_MINUTE;
    }

    // implementing the method of interface Comparable

    public int compareTo (Object o) {

        if (! (o instanceof Time))
          throw new ClassCastException("Not a Time instance");

        Time other = (Time) o;

        return timeInSeconds - other.timeInSeconds;
    }

    // standard methods

    public String toString () {
        int h = getHours ();
        int m = getMinutes ();
        int s = getSeconds ();

        String hh = h < 10 ? "0" + h : "" + h;
        String mm = m < 10 ? "0" + m : "" + m;
        String ss = s < 10 ? "0" + s : "" + s;

        return  hh + ":" + mm + ":" + ss;
    }

    public boolean equals(Object t) {
        return timeInSeconds == ((Time) t).timeInSeconds;
    }
}
