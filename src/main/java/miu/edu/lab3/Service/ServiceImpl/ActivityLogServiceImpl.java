package miu.edu.lab3.Service.ServiceImpl;


import lombok.RequiredArgsConstructor;
import miu.edu.lab3.Entity.ActivityLog;
import miu.edu.lab3.Repository.ActivityLogRepo;
import miu.edu.lab3.Service.ActivityLogService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
    public class ActivityLogServiceImpl implements ActivityLogService {
        private final ActivityLogRepo activityLogRepo;

        @Override
        public void save(ActivityLog p) {
            activityLogRepo.save(p);
        }

        @Override
        public void delete(int id) {
            activityLogRepo.deleteById(id);
        }

        @Override
        public ActivityLog getById(int id) {

            var item = activityLogRepo.findById(id).get();


            return item;
        }

        @Override
        public List<ActivityLog> getAll() {
            var result = new ArrayList<ActivityLog>();
            activityLogRepo.findAll().forEach(result::add);
            return  result;
        }
    }

