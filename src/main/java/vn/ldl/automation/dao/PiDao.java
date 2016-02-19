package vn.ldl.automation.dao;

import java.util.List;

import vn.ldl.automation.entity.Pi;

/**
 * @author xuanlinhha
 * 
 */

public interface PiDao {

	public void saveOrUpdate(Pi pi);

	public Pi getById(long id);

	public Pi getByOwner(String username);

	// get all pi infos except server
	public List<Pi> getAllInfos();
}
