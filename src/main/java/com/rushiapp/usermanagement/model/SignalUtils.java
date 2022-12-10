public package ai.salesken.web.utils;

import ai.salesken.web.enums.SignalDimensionFontType;
import ai.salesken.web.enums.SignalDimensions;

import java.awt.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SignalUtils {

	private static final String DEFAULT_DIMENSION_BACKGROUND_COLOR = "#BDBDBD";
	private static final String DEFAULT_DIMENSION_TEXT_COLOR = "#ffffff";

	private static Map<String, Map<String, String>> categoryToColorMap = null;
	private static Map<String, String> categoryToReportMap = null;
	private static Map<String, String> categoryToMathType = null;
	private static Map<String, String> durationConstraint = null;
	static {
		Map<String, Map<String, String>> categoryToColor = new HashMap<>();
		categoryToColor.put(SignalDimensions.Opening.label, getDimensionFontAttributes("#24b3c9"));
		categoryToColor.put(SignalDimensions.Lead_Qualification.label, getDimensionFontAttributes("#d5872a"));
		categoryToColor.put(SignalDimensions.Need_Discovery.label, getDimensionFontAttributes("#781de2"));
		categoryToColor.put(SignalDimensions.Aspiration.label, getDimensionFontAttributes("#6CA67C"));
		categoryToColor.put(SignalDimensions.Product_Knowledge.label, getDimensionFontAttributes("#49B691"));
		categoryToColor.put(SignalDimensions.Price_Objection.label, getDimensionFontAttributes("#E30B5C"));
		categoryToColor.put(SignalDimensions.Empathy.label, getDimensionFontAttributes("#bc4385"));
		categoryToColor.put(SignalDimensions.Rapport_Building.label, getDimensionFontAttributes("#610b70"));
		categoryToColor.put(SignalDimensions.Key_Value_Proposition.label, getDimensionFontAttributes("#afb24d"));
		categoryToColor.put(SignalDimensions.Objections.label, getDimensionFontAttributes("#CA3435"));
		categoryToColor.put(SignalDimensions.Delay_Objection.label, getDimensionFontAttributes("#C53151"));
		categoryToColor.put(SignalDimensions.Objection_Handling.label, getDimensionFontAttributes("#FF4681"));
		categoryToColor.put(SignalDimensions.Price_Discussion.label, getDimensionFontAttributes("#c9246c"));
		categoryToColor.put(SignalDimensions.Decision_Maker_Objection.label, getDimensionFontAttributes("#FF404C"));
		categoryToColor.put(SignalDimensions.Positive_Energy.label, getDimensionFontAttributes("#58a75c"));
		categoryToColor.put(SignalDimensions.Consultative_Selling.label, getDimensionFontAttributes("#2d59d2"));
		categoryToColor.put(SignalDimensions.Mis_sell.label, getDimensionFontAttributes("#FB4D46"));
		categoryToColor.put(SignalDimensions.Listening_Skills.label, getDimensionFontAttributes("#df8e20"));
		categoryToColor.put(SignalDimensions.Closing.label, getDimensionFontAttributes("#136655"));
		categoryToColor.put(SignalDimensions.Previous_Call_Summary.label, getDimensionFontAttributes("#24b3c9"));
		categoryToColor.put(SignalDimensions.Confidence.label, getDimensionFontAttributes("#2b8ad4"));
		categoryToColor.put(SignalDimensions.Politeness.label, getDimensionFontAttributes("#f25377"));
		categoryToColor.put(SignalDimensions.Sorry.label, getDimensionFontAttributes("#832A0D"));
		categoryToColor.put(SignalDimensions.Joy.label, getDimensionFontAttributes("#d7b028"));
		categoryToColor.put(SignalDimensions.Satisfaction.label, getDimensionFontAttributes("#4ca371"));
		categoryToColor.put(SignalDimensions.Curiosity.label, getDimensionFontAttributes("#a94313"));
		categoryToColor.put(SignalDimensions.Assertiveness.label, getDimensionFontAttributes("#d71e55"));
		categoryToColor.put(SignalDimensions.Angry.label, getDimensionFontAttributes("#d90000"));
		categoryToColor.put(SignalDimensions.Worry.label, getDimensionFontAttributes("#a61e75"));
		categoryToColor.put(SignalDimensions.Frustration.label, getDimensionFontAttributes("#691231"));
		categoryToColor.put(SignalDimensions.Superlative.label, getDimensionFontAttributes("#0A7E8C"));
		categoryToColor.put(SignalDimensions.Urgency_Creation.label, getDimensionFontAttributes("#c03f41"));
		categoryToColor.put(SignalDimensions.Others.label, getDimensionFontAttributes("#8D90A1"));

		categoryToColor.put(SignalDimensions.Opening.label, getDimensionFontAttributes("#24b3c9"));
		categoryToColorMap = Collections.unmodifiableMap(categoryToColor);
	}

	static {
		Map<String, String> categoryToSpeaker = new HashMap<>();
		categoryToSpeaker.put(SignalDimensions.Objections.label, SignalSpeaker.Customer.name());
		categoryToMathType = Collections.unmodifiableMap(categoryToSpeaker);
	}
	static {
		Map<String, String> durationConstraintForOpeningAndClosing = new HashMap<>();
		durationConstraintForOpeningAndClosing.put(SignalDimensions.Opening.label,
				DurationConstraint.FIRST_TWO_MINUTE.name());
		durationConstraintForOpeningAndClosing.put(SignalDimensions.Closing.label,
				DurationConstraint.LAST_TWO_MINUTE.name());
		durationConstraint = Collections.unmodifiableMap(durationConstraintForOpeningAndClosing);
	}
	static {
		Map<String, String> categoryToReportTag = new HashMap<>();
		// script intelligence
 		categoryToReportTag.put(SignalDimensions.Opening.label, DimensionReportingTags.SCRIPT_INTELLIGENCE.name());
		categoryToReportTag.put(SignalDimensions.Lead_Qualification.label,
				DimensionReportingTags.SCRIPT_INTELLIGENCE.name());
		categoryToReportTag.put(SignalDimensions.Need_Discovery.label,
				DimensionReportingTags.SCRIPT_INTELLIGENCE.name());
		categoryToReportTag.put(SignalDimensions.Key_Value_Proposition.label,
				DimensionReportingTags.SCRIPT_INTELLIGENCE.name());
		categoryToReportTag.put(SignalDimensions.Product_Knowledge.label,
				DimensionReportingTags.SCRIPT_INTELLIGENCE.name());
		categoryToReportTag.put(SignalDimensions.Price_Discussion.label,
				DimensionReportingTags.SCRIPT_INTELLIGENCE.name());
		categoryToReportTag.put(SignalDimensions.Closing.label, DimensionReportingTags.SCRIPT_INTELLIGENCE.name());

		// selling best practices
 		categoryToReportTag.put(SignalDimensions.Consultative_Selling.label, "");
		categoryToReportTag.put(SignalDimensions.Empathy.label, "");
		categoryToReportTag.put(SignalDimensions.Listening_Skills.label, "");
		categoryToReportTag.put(SignalDimensions.Confidence.label, "");
		categoryToReportTag.put(SignalDimensions.Politeness.label, "");

		categoryToReportMap = Collections.unmodifiableMap(categoryToReportTag);
	}

	public static String getDimensionTextColor(String dimension) {
		// Get Color
		if (categoryToColorMap.containsKey(dimension)) {
			return categoryToColorMap.get(dimension).get(SignalDimensionFontType.TEXT_COLOR.name());
		} else {
			// Unknown/Default Color
			return DEFAULT_DIMENSION_TEXT_COLOR;
		}
	}

	public static String getDurationConstraint(String dimension) {
		// Get duration constraint
		if (durationConstraint.containsKey(dimension)) {
			return durationConstraint.get(dimension);
		} else {
			return DurationConstraint.ANYTIME.name();
		}
	}

	public static String getDimensionSignalSpeaker(String dimension) {
		// Get Speaker
		if (categoryToMathType.containsKey(dimension)) {
			return categoryToMathType.get(dimension);
		} else {
			return SignalSpeaker.Agent.name();
		}
	}

	public static String getReportTypeByDimension(String dimension) {
		// Get Report
		if (categoryToReportMap.containsKey(dimension)) {
			return categoryToReportMap.get(dimension);
		} else {
			// Set Generic signals Report
			return DimensionReportingTags.GENERIC_SIGNALS.name();
		}
	}

	public static String getDimensionColor(String dimension) {
		// Get Color
		if (categoryToColorMap.containsKey(dimension)) {
			return categoryToColorMap.get(dimension).get(SignalDimensionFontType.BACKGROUND_COLOR.name());
		} else {
			// Unknown/Default Color
			return DEFAULT_DIMENSION_BACKGROUND_COLOR;
		}
	}

	private static Map<String, String> getDimensionFontAttributes(String backgroundColor) {
		HashMap<String, String> dimensionFontAttributes = new HashMap<>();
		dimensionFontAttributes.put(SignalDimensionFontType.BACKGROUND_COLOR.name(), backgroundColor);
		dimensionFontAttributes.put(SignalDimensionFontType.TEXT_COLOR.name(),
				getContrastColor(Color.decode(backgroundColor)));
		return dimensionFontAttributes;
	}

	private static String getContrastColor(Color color) {
		return "#ffffff";
	}
}

 SignalUtils {
    
}
