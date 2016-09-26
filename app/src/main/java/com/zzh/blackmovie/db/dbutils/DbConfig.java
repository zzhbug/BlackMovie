package com.zzh.blackmovie.db.dbutils;

import android.content.Context;

import com.zzh.blackmovie.db.entity.DownLoadEntity;
import com.zzh.blackmovie.db.entity.HistoryMovieEntity;
import com.zzh.blackmovie.db.entity.JsonEntity;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class DbConfig {
    private static Context mContext;
    private static RealmConfiguration realmConfiguration;
    private static Realm realm;

    public static void InitDbConfig(Context context) {
        mContext = context;
        realmConfiguration = new RealmConfiguration.Builder(context)
                .name("zhang.realm")
                .schemaVersion(2)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.createObject(DownLoadEntity.class);
        realm.createObject(HistoryMovieEntity.class);
        realm.createObject(JsonEntity.class);
        realm.commitTransaction();
    }

    public static Realm getRealm() {
        if (realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }
        return realm;
    }


}
