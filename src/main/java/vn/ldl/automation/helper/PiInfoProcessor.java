package vn.ldl.automation.helper;

import vn.ldl.automation.entity.Pi;
import vn.ldl.automation.exchange.FormatConst;

/**
 * @author xuanlinhha
 * 
 * 
 */
public class PiInfoProcessor {
	static public Pi convertPiInfo(String address, String piData) {
		Pi pi = null;
		// [id key]
		String[] elements = piData.split(FormatConst.SUB_COMP_SEPERATOR);
		if (elements.length == 2) {
			pi = new Pi();
			pi.setId(Long.parseLong(elements[0]));
			pi.setKey(elements[1]);
			pi.setAddress(address);
			pi.setEnabled(true);
		}
		return pi;
	}
}
