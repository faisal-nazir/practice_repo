package interview.pro.daily.problem;

public class ClockAngles {

	// https://en.wikipedia.org/wiki/Clock_angle_problem
	// https://stackoverflow.com/questions/2748965/find-angle-between-hour-and-minute-hands-in-an-analog-clock
	
	/** A method to solve such problems is to consider the rate of change of the angle in degrees per minute.
	 *  The hour hand of a normal 12-hour analog clock turns 360° in 12 hours (720 minutes) or 0.5° per minute.
	 *  The minute hand rotates through 360° in 60 minutes or 6° per minute.
	 */
	public static double angle(int hr, int min) {
		double h_angle = 0.5d * (hr * 60 + min);
		double m_angle = 6.0d * min;
		double angle = Math.abs(h_angle - m_angle);
		angle = Math.min(angle, 360 - angle);
		return angle;
	}
	
	public static void main(String[] args) {
		System.out.println(angle(3, 30));
		System.out.println(angle(12, 30));
	}
}
