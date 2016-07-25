package app.gm.com.more;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.tv);
        String str = "";
        String packName = this.getPackageName();
        str += "包名：" + packName;

        PackageManager packageManager = this.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packageInfo;
        try {
            Bundle metaData = packageManager.getApplicationInfo(
                    this.getPackageName(), PackageManager.GET_META_DATA).metaData;

            String test = (String) metaData.get("GMTEST");
            String gm = (String) metaData.get("GM");
            str += "\n" + "test：" + test;
            str += "\n" + "gm：" + gm;
            packageInfo = packageManager.getPackageInfo(packName, 0);
            String apkVerName = packageInfo.versionName;
            int apkVerCode = packageInfo.versionCode;
            str += "\n" + "apkVerName：" + apkVerName;
            str += "\n" + "apkVerCode：" + apkVerCode;
        } catch (Exception e) {
        }
        tv.setText(str);
    }
}
