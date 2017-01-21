package com.example.storeManagement.services.diary;

import com.example.storeManagement.dao.ActionDao;
import com.example.storeManagement.domain.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daniel on 11/3/2016.
 */
@Transactional
@Service("diaryManagementService")
public class DiaryManagementServiceImpl implements DiaryManagementService {


    private ActionDao actionDao;

    @Autowired
    public DiaryManagementServiceImpl(ActionDao actionDao) {
        this.actionDao = actionDao;
    }

    @Override
    public void recordAction(Action action) {

        actionDao.create(action);
    }

    @Override
    public List<Action> getAllIncompleteActions(String requiredUser) {
        return actionDao.getIncompleteActions(requiredUser);
    }
}
