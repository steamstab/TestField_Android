package com.steamstab.testfield.rx;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.steamstab.testfield.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/**
 * Created by Steam on 16/12/22.
 */

public class RxjavaTest extends Activity {

    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    EditText text;

    TextView mTextView;
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_rxjava);
//        mTextView = (TextView) findViewById(R.id.button);
//        text = (EditText) findViewById(R.id.edit);


        list1.add("1");
        list1.add("2");
        list1.add("3");
        list2.add("4");
        list2.add("5");
        list2.add("6");
        list2.add("7");

//        merge();
//        zip();
//        filter();
//        repeat();
//        range();
//        interval();

//        final PublishSubject subject = PublishSubject.create();
//        debounce(subject);
//        mTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                subject.onNext(++num);
//            }
//        });

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 5; i++) {
                    subscriber.onNext(i);
                }
            }
        }).map(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
//                if(integer == 3){
//                    mTextView.setText("");
//                }
                return integer;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Observable completed");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Oh,no! Something wrong happened！");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Item is " + integer);
            }
        });


    }

    void creat() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 5; i++) {
                    subscriber.onNext(i);
                }
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Observable completed");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Oh,no! Something wrong happened！");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Item is " + integer);
            }
        });
    }

    void from() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Observable.from(list1)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {

                    }
                });
    }

    void repeat() {
        Observable.just(1, 2, 3)
                .repeat(3)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("repeat : " + integer + "");
                    }
                });
    }

//    void defer() {
//        Observable.defer(this::getInt).subscribe(new Action1<Object>() {
//            @Override
//            public void call(Object o) {
//
//            }
//        });
//    }
//
//    Observable getInt() {
//        return Observable.just(1, 2, 3);
//    }

    void range(){
        Observable.range(10, 4)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("range : " + integer + "");
                    }
                });
    }

    void interval(){
        Observable.interval(2, TimeUnit.SECONDS) //两秒发送一次
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        System.out.println("interval : " + aLong + "");
                    }
                });
    }

    void timer(){
        Observable.timer(3, TimeUnit.SECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        System.out.println("timer : " + aLong + "");
                    }
                });
    }

    void timeout(PublishSubject<Integer> subject){
        subject.timeout(3, TimeUnit.SECONDS)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("no click");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("click : " + integer);
                    }
                });
    }

    void debounce(PublishSubject<Integer> subject){
        subject.debounce(3, TimeUnit.SECONDS)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("no click");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("click : " + integer);
                    }
                });
    }

    void merge() {
        Observable observable1 = Observable.from(list1);
        Observable observable2 = Observable.from(list2);

        Observable.merge(observable1, observable2)
                .subscribe(new Action1() {
                    @Override
                    public void call(Object o) {
                        System.out.println("merge : " + o + "");
                    }
                });
    }

    void zip() {
        Observable observable1 = Observable.from(list1);
        Observable observable2 = Observable.from(list2);

        Observable
                .zip(observable1, observable2, new Func2<String, String, String>() {
                    @Override
                    public String call(String s, String s2) {
                        return s + s2;
                    }
                })
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        System.out.println("zip : " + o + "");
                    }
                });
    }

    void filter() {
        Observable observable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9);

        observable.filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer o) {
                return o > 5;
            }
        }).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("filter : " + o + "");
            }
        });
    }
}
