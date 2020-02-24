package com.example.designpattern.create.singleton.second;//package com.example.designpattern.singleton.second;
//
//import java.util.concurrent.atomic.AtomicLong;
//
///**
// * Created by zyy on 20/2/16.
// */
//public class IdGenerator {
//
//    private AtomicLong id = new AtomicLong(0);
//    private static IdGenerator instance;
//    private static SharedObjectStorage storage = FileSharedObjectStorage(/*入参省略，比如文件地址*/);
//    private static DistributedLock lock = new DistributedLock();
//
//    private IdGenerator() {}
//
//    public synchronized static IdGenerator getInstance() {
//        if (instance == null) {
//            lock.lock();
//            instance = storage.load(IdGenerator.class);
//        }
//        return instance;
//    }
//
//    public synchroinzed void freeInstance() {
//        storage.save(this, IdGeneator.class);
//        instance = null; //释放对象
//        lock.unlock();
//    }
//
//    public long getId() {
//        return id.incrementAndGet();
//    }
//
////    public static void main(String[]args){
////        // IdGenerator使用举例
////        IdGenerator idGeneator = IdGenerator.getInstance();
////        long id = idGenerator.getId();
////        IdGenerator.freeInstance();
////    }
//
//}
