package miu.edu.lab3.Service;

import miu.edu.lab3.Entity.ActivityLog;

import java.util.List;

public interface ActivityLogService {
        void save(ActivityLog p);

        void delete(int id);

        ActivityLog getById(int id);

        List<ActivityLog> getAll();
    }

