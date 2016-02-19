package vn.ldl.automation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ldl.automation.dao.PiDao;
import vn.ldl.automation.entity.Pi;
import vn.ldl.automation.exchange.IRequest;
import vn.ldl.automation.exchange.IRequestHandler;
import vn.ldl.automation.exchange.IResponse;
import vn.ldl.automation.exchange.IResponseParser;
import vn.ldl.automation.exchange.Node;

/**
 * @author xuanlinhha
 * 
 * 
 */

@Service
public class InteractionServiceImpl implements InteractionService {

	@Autowired
	PiDao piDao;

	@Override
	public List<Node> display(String username, String id) {
		List<Node> nodes = null;
		Pi pi = piDao.getByOwner(username);
		if (pi != null) {
			IRequest request = new IRequest();
			request.setType(IRequest.DISPLAY);
			request.setId(id);
			request.setAutoVersionMajor(1);
			request.setAutoVersionMajor(0);
			IResponse response = IRequestHandler.handleIRequest(
					pi.getAddress(), request);
			if (response != null
					&& response.getStatus().equals(IResponse.SUCCESS)) {
				nodes = IResponseParser.parserStringToNodes(response.getData());
			}
		}
		return nodes;
	}

	@Override
	public String setStatus(String username, String id, List<Integer> params) {
		Pi pi = piDao.getByOwner(username);
		if (pi != null) {
			IRequest request = new IRequest();
			request.setType(IRequest.SET);
			request.setId(id);
			request.setAutoVersionMajor(1);
			request.setAutoVersionMajor(0);
			request.setParams(params);
			IResponse response = IRequestHandler.handleIRequest(
					pi.getAddress(), request);
			return response.getStatus();
		}
		return null;
	}

}
