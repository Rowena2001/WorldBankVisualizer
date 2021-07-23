/**
 * Abstract Class AnalysisType
 * A1 - A8 extend this abstract class
 */
public abstract class AnalysisType {
	
	/**
	 * title of the analysis
	 */
	protected static String title;
	/**
	 * world bank indicators of the analysis type
	 */
	protected static String[] indicators;
	/**
	 * units of the AnalysisType instance
	 */
	protected String[] units;
	
	/**
	 * Performs calculation with data to be used by Viewers
	 * @return array of Data objects (datasets)
	 * Length of array (number of data objects) depends on the number of series 
	 */
	abstract Data[] calculate();
	
	/**
	 * instatiated version of static getTitle()
	 * @return String title of the analysis type instance
	 */
	abstract String getInstTitle();
	
	/**
	 * 
	 * @return String[] containing the units of the AnalysisType
	 */
	public String[] getUnits() {
		return units;
	}
	
	/**
	 * 
	 * @return statically defined title string for the AnalysisType
	 */
	public static String getTitle() {
		return title;
	}
	
	/**
	 * 
	 * @return String[] containing the World Bank indicators for the analysis type
	 */
	public static String[] getIndicators() {
		return indicators;
	}
}
