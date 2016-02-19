package vn.ldl.automation.service;

import java.util.List;

import vn.ldl.automation.exchange.Node;

/**
 * @author xuanlinhha
 * 
 * 
 */
public interface InteractionService {

	List<Node> display(String username, String id);

	String setStatus(String username, String id, List<Integer> params);
}
