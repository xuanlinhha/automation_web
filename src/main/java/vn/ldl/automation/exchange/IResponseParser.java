package vn.ldl.automation.exchange;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class IResponseParser {

	public static List<Node> parserStringToNodes(String data) {
		if (StringUtils.isBlank(data)) {
			return null;
		}
		List<Node> nodes = new ArrayList<Node>();
		String[] sNodes = data.split(FormatConst.LIST_SEPERATOR);
		for (String sNode : sNodes) {
			Node node = parseNode(sNode);
			nodes.add(node);
		}
		return nodes;
	}

	private static Node parseNode(String data) {
		if (StringUtils.isBlank(data)) {
			return null;
		}
		Node node = new Node();
		// TYPE ID DESCRIPTION STATUS
		String[] elements = data.split(FormatConst.COMP_SEPERATOR);
		if (elements.length == 4) {
			node = new Node();
			node.setType(elements[0]);
			node.setId(elements[1]);
			node.setDescription(elements[2]);
			List<Integer> status = new ArrayList<Integer>();
			String[] sStatus = elements[3]
					.split(FormatConst.SUB_COMP_SEPERATOR);
			for (String s : sStatus) {
				status.add(Integer.parseInt(s));
			}
			node.setStatus(status);
		}
		return node;
	}
}
