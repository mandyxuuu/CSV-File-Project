package project;

/**
 * <p>Title: Majors</p>
 *
 * <p>Description: This class contains the headers in the CSV file. </p>
 *
 * @author Minliang Xu
 */

public class Major implements Comparable<Major>{

	//instance variables
	private int majorCode;
	private String majorName;
	private String majorCategory;
	private int numTotal;
	private int numEmployed;
	private int numFullTime;
	private int numUnemployed;
	private double unemployedRate;
	private int median;
	private int P25;
	private float P75;

	/**
	 * parameterized constructor sets all the instance variables to the specific values base on the user.
	 *@param code to be stored in majorCode
	 *@param mName to be store	in majorName
	 *@param mCategory to be store in majorCategory
	 *@param total to be store in numTotal
	 *@param employed to be store in numEmployed
	 *@param fulltime to be store in numFullTime
	 *@param unemployed to be store in numUnemployed
	 *@param rateNoWork to be store in unemployedRate
	 *@param m to be store in median
	 *@param numP25 to be store in P25
	 *@param numP75 to be store in P75
	 */
	public Major(String code, String mName, String mCategory, String total, String employed, String fulltime, 
			String unemployed, String rateNoWork, String m, String numP25, String numP75)
	{
		//remove to lowercase for majorName and majorCategory (project 3)
		majorCode = Integer.parseInt(code);
		majorName = mName;
		majorCategory = mCategory;
		numTotal = Integer.parseInt(total);
		numEmployed = Integer.parseInt(employed);
		numFullTime = Integer.parseInt(fulltime);
		numUnemployed = Integer.parseInt(unemployed);
		unemployedRate = Double.parseDouble(rateNoWork);
		median = Integer.parseInt(m);
		P25 = Integer.parseInt(numP25);
		P75 = Float.parseFloat(numP75);

	}
	
	 //default constructor
	public Major()
	{
		majorCode = 0;
		majorName = new String();
		majorCategory = new String();
		numTotal = 0;
		numEmployed = 0;
		numFullTime = 0;
		numUnemployed = 0;
		unemployedRate = 0.0;
		median = 0;
		P25 = 0;
		P75 = 0.0f;

	}
	/**
	 * getMajorCode method 
	 * This is the accessor method for majorCode
	 * @return the value stored in the instance variable majorCode
	 */

	public int getMajorCode() {
		return majorCode;
	}

	/**
	 * setMajorCode - stores a new value in majorCode
	 * @param code - the reference to be stored in majorCode
	 */
	public void setMajorCode(int code)
	{
		majorCode = code;
	}

	/**
	 * getMajorName method 
	 * This is the accessor method for majorName
	 * @return the value stored in the instance variable majorName
	 */

	public String getMajorName() {
		return majorName;
	}

	/**
	 * setMajorName - stores a new value in majorName
	 * @param n - the reference to be stored in majorName
	 */
	public void setMajorName(String n)
	{
		majorName = n;
	}

	/**
	 * getMajorCategory method 
	 * This is the accessor method for majorCategory
	 * @return the value stored in the instance variable majorCategory
	 */

	public String getMajorCategory() {
		return majorCategory;
	}

	/**
	 * setMajorCode - stores a new value in majorCategory
	 * @param code - the reference to be stored in majorCategory
	 */
	public void setMajorCategory(String c)
	{
		majorCategory = c;
	}

	/**
	 * getNumTotal method 
	 * This is the accessor method for numTotal
	 * @return the value stored in the instance variable numTotal
	 */

	public int getNumTotal() {
		return numTotal;
	}

	/**
	 * setNumTotal - stores a new value in numTotal
	 * @param num - the reference to be stored in numTotal
	 */
	public void setNumTotal(int num)
	{
		numTotal= num;
	}

	/**
	 * getNumEmployed method 
	 * This is the accessor method for numEmployed
	 * @return the value stored in the instance variable numEmployed
	 */

	public int getNumEmployed() {
		return numEmployed;
	}

	/**
	 * setNumEmployed - stores a new value in numEmployed
	 * @param num - the reference to be stored in numEmployed
	 */
	public void setNumEmployed(int num)
	{
		numEmployed = num;
	}

	/**
	 * getNumFullTime method 
	 * This is the accessor method for numFullTime
	 * @return the value stored in the instance variable numFullTime
	 */

	public int getNumFullTime() {
		return numFullTime;
	}

	/**
	 * setNumFullTime - stores a new value in numFullTime
	 * @param num - the reference to be stored in numFullTime
	 */
	public void setNumFullTime(int num)
	{
		numFullTime = num;
	}
	/**
	 * getNumEmployed method 
	 * This is the accessor method for numUnemployed 
	 * @return the value stored in the instance variable numUnemployed
	 */

	public int getNumUnemployed() {
		return numUnemployed;
	}

	/**
	 * setNumUnemployed - stores a new value in numUnemployed 
	 * @param num - the reference to be stored in numUnemployed
	 */
	public void setNumUnemployed(int num)
	{
		numUnemployed = num;
	}

	/**
	 * getUnemployedRate method 
	 * This is the accessor method for unemployedRate
	 * @return the value stored in the instance variable unemployedRate
	 */

	public double getUnemployedRate() {
		return unemployedRate;
	}

	/**
	 * setUnemployedRate - stores a new value in unemployedRate
	 * @param rate - the reference to be stored in unemployedRate
	 */
	public void setUnemployedRate(double rate)
	{
		unemployedRate = rate;
	}

	/**
	 * getMedian method 
	 * This is the accessor method for median		
	 * @return the value stored in the instance variable median
	 */

	public int getMedian() {
		return median;
	}

	/**
	 * setMedian - stores a new value in median
	 * @param m - the reference to be stored in median
	 */
	public void setMedian(int m)
	{
		median = m;
	}

	/**
	 * getP25 method 
	 * This is the accessor method for P25
	 * @return the value stored in the instance variable P25
	 */

	public int getP25() {
		return P25;
	}

	/**
	 * setP25 - stores a new value in P25
	 * @param num - the reference to be stored in P25
	 */
	public void setP25(int num)
	{
		P25 = num;
	}


	/**
	 * getP75 method 
	 * This is the accessor method for P75
	 * @return the value stored in the instance variable P75
	 */

	public float getP75() {
		return P75;
	}

	/**
	 * setP75 - stores a new value in P75
	 * @param num - the reference to be stored in P75
	 */
	public void setP75(float num75)
	{
		P75 = num75;
	}
	
	public int compareTo(Major other) {
		return 0;
	}
	
	/**
	 * compareName method //for project 2
	 * This method is to compare of the values of names
	 * @return a negative value if majorName of other is smaller
	 *         a positive value if majorName of other is larger
	 *         0 if the values are same
	 * @param other - String that pass to the method
	 */
	public int compareName(String other) {
		return majorName.compareTo(other);
	}
	/**
	 * compareCategory method //for project 2
	 * This method is to compare of the values of category
	 * @return a negative value if Category of other is smaller
	 *         a positive value if this Category of otheris larger
	 *         0 if the values are same
	 * @param other - String that pass to the method
	 */

	public int compareCategory(String other) {
		return majorCategory.compareTo(other);
	}

	/**
	 * compareTotal method //for project 2
	 * This method is to compare of the values of numTotal
	 * @return a negative value if the numTotal of other smaller
	 *         a positive value if numTotal of other is larger
	 *         0 if the values are same
	 * @param other - integer that pass to the method
	 */

	public int compareTotal(int other) {
		return (this.numTotal-other);
	}

	/**
	 * compareNumEmployed method //for project 2
	 * This method is to compare of the values of NumEmployed
	 * @return a negative value if the other's numEmployed is smaller
	 *         a positive value if other's numEmployed is larger
	 *         0 if the values are same
	 * @param other - integer that pass to the method
	 */

	public int compareEmployed(int other) {
		return (this.numEmployed-other);
	}

	/**
	 * compareNumFullTime method //for project 2
	 * This method is to compare of the values of NumFullTime
	 * @return a negative value if the other's NumFullTime is smaller
	 *         a positive value if other's NumFullTime is larger
	 *         0 if the values are same
	 * @param other - integer that pass to the method
	 */

	public int compareFullTime(int other) {
		return (this.numFullTime-other);
	}

	/**
	 * compareNumUnemployed method //for project 2
	 * This method is to compare of the values of NumUnemployed
	 * @return a negative value if the other's NumUnemployed is smaller
	 *         a positive value if other's NumUnemployed is larger
	 *         0 if the values are same
	 * @param other - integer that pass to the method
	 */

	public int compareUnemployed(int other){
		return (this.numUnemployed-other);
	}
	
	/**
	 * compareUnemployedRate method //for project 2
	 * This method is to compare of the values ofunemployed ate
	 * @return a negative value if the other's unmeployed rate is smaller
	 *         a positive value if other's unemployed rate is larger
	 *         0 if the values are same
	 * @param other - double that pass to the method
	 */
	
	public int compareUnemployedRate(double other){
		return Double.compare(this.unemployedRate, other);
	}
	/**
	 * compareMedian method //for project 2
	 * This method is to compare of the values of median
	 * @return a negative value if the other's median is smaller
	 *         a positive value if other's median is larger
	 *         0 if the values are same
	 * @param other - integer that pass to the method
	 */
	public int compareMedian(int other) {
		return (this.median-other);
	}
	
	/**
	 * compareP25 method //for project 2
	 * This method is to compare of the values of P25
	 * @return a negative value if the other's P25 is smaller
	 *         a positive value if other's P25 is larger
	 *         0 if the values are same
	 * @param other - integer that pass to the method
	 */
	public int compareP25(int other) {
		return (this.P25-other);
	}
	
	/**
	 * compareP75 method //for project 2
	 * This method is to compare of the values of P75
	 * @return a negative value if the other's P75 is smaller
	 *         a positive value if other's P75 is larger
	 *         0 if the values are same
	 * @param other - float value that pass to the method
	 */
	public int compareP75(float other) {
		
		return Float.compare(this.P75, other);
	}

	/**
	 * toString method 
	 * This method creates and returns a reference to a String object
	 * @return the values stored in the instance variables
	 */
	public String toString() {

		String str = new String(majorCode + "  Name: " + majorName + "  Category: " + majorCategory + "  Total: " + numTotal + "  Employed: " +
				numEmployed + "\nFull Time: " + numFullTime + "  Unemployed: " + numUnemployed + "  Unemployed Rate: " + unemployedRate + 
				"  Median: " + median + "  P25: " + P25 + "  P75: " + P75 +"\n");	
		return str;
	}

}
