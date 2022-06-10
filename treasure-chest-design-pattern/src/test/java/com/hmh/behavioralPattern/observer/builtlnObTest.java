package com.hmh.behavioralPattern.observer;

import com.hmh.behavioralPattern.observer.builtIn.Observer1;
import com.hmh.behavioralPattern.observer.builtIn.server.SubjectFor3d;
import com.hmh.behavioralPattern.observer.builtIn.server.SubjectForSSQ;

public class builtlnObTest {
    public static void main(String[] args) {
        SubjectFor3d subjectFor3d = new SubjectFor3d() ;
        SubjectForSSQ subjectForSSQ = new SubjectForSSQ() ;

        Observer1 observer1 = new Observer1();
        observer1.registerSubject(subjectFor3d);
        observer1.registerSubject(subjectForSSQ);


        subjectFor3d.setMsg("hello 3d'nums : 110 ");
        subjectForSSQ.setMsg("ssq'nums : 12,13,31,5,4,3 15");
    }
}
