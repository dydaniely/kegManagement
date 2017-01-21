package com.example.storeManagement.dao;

import com.example.storeManagement.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActionDaoHibernateImpl implements ActionDao {
	//private static final String GET_INCOMPLETE_SQL = "SELECT ACTION_ID, DETAILS, COMPLETE, OWNING_USER, REQUIRED_BY FROM ACTION WHERE OWNING_USER=? AND COMPLETE=?";


 	private HibernateTemplate hibernateTemplate;

	@Autowired
	public ActionDaoHibernateImpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void create(Action newAction) {
		hibernateTemplate.save(newAction);
	}

	public List<Action> getIncompleteActions(String userId) {
		return null;
	}

	public void update(Action actionToUpdate) throws RecordNotFoundException {
		this.hibernateTemplate.update(actionToUpdate);
	}

	public void delete(Action oldAction) throws RecordNotFoundException {
		String foundAction = (String) hibernateTemplate.get(String.valueOf(oldAction.getActionId()), Action.class);

		if (!foundAction.isEmpty()) {
			this.hibernateTemplate.delete(oldAction.getActionId());
		}

	}
}

	/*class ActionRowMapper implements RowMapper<Action> {
		public Action mapRow(ResultSet rs, int arg1) throws SQLException {
			int actionId = rs.getInt(1);
			String details = rs.getString(2);
			boolean complete = rs.getBoolean(3);
			String owningUser = rs.getString(4);
			Date requiredBy = rs.getDate(5);

			Calendar requiredByCal = new java.util.GregorianCalendar();
			requiredByCal.setTime(requiredBy);

			return new Action("" + actionId, details, requiredByCal, owningUser, complete);
		}
	}*/
