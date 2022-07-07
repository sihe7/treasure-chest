package com.hmh;

import com.hmh.utils.SecurityUtil;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiApplicationTests {

    //Activiti7 提供了两个新的API ProcessRuntime和TaskRuntime，
    // 但是这两个API必须使用Spring Security，这对于项目没有引入Spring Security是非常不友好的。
    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private SecurityUtil securityUtil;
    //以前要查询待办任务是一个方法，查询候选人任务是另一个方法，activiti7现在将其封装成一个方法
    @Autowired
    private TaskRuntime taskRuntime;
    //1：获取当前登录用户任务
    @Test
    public void getTasks() {
        securityUtil.logInAs("ryandawsonuk");
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0,100));
        List<Task> list=tasks.getContent();
        for(Task tk : list){
            System.out.println("-------------------");
            System.out.println("getId："+ tk.getId());
            System.out.println("getName："+ tk.getName());
            System.out.println("getStatus："+ tk.getStatus());
            System.out.println("getCreatedDate："+ tk.getCreatedDate());
            if(tk.getAssignee() == null){
                System.out.println("Assignee：待拾取任务");
            }else{
                System.out.println("Assignee："+ tk.getAssignee());
            }
        }
    }
    //完成任务
    @Test
    public void completeTask() {
        securityUtil.logInAs("ryandawsonuk");
        Task task = taskRuntime.task("db9c5f80-d3ae-11ea-99e8-dcfb4875e032");
        if(task.getAssignee() == null){
            taskRuntime.claim(TaskPayloadBuilder.claim()
                    .withTaskId(task.getId())
                    .build());
        }
        taskRuntime.complete(TaskPayloadBuilder
                .complete()
                .withTaskId(task.getId())
                .build());
        System.out.println("任务执行完成");
    }
}

