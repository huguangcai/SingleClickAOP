# SingleClickAOP
## AOP的方式实现防止按钮短时间内连续点击
# 使用
1、在项目的build.gradle中的buildscript中的dependencies添加：
```
dependencies {
    ...
    classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.10'
    classpath 'org.aspectj:aspectjtools:1.9.2'
    classpath 'org.aspectj:aspectjweaver:1.9.2'
}
```
2、在项目的build.gradle中的allprojects中的repositories添加：
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

3、在app的build.gradle中的最上面添加
```
apply plugin: 'android-aspectjx'
```
4、在app的build.gradle中的dependencies添加
```
implementation 'com.guangcai.singleclick:singleclick:1.0.0'
```
## 使用方法
# 在java中
```
@SingleClick
@Override
public void onClick(View v) {
    switch (v.getId()) {
        case R.id.btnClick:
          Toast.makeText(this,"啊啊啊啊",Toast.LENGTH_SHORT).show()
        break;
    }
}
```
# Kotlin中
```
@SingleClick
override fun onClick(v: View?) {
    if (v != null) {
        when(v.id){
            R.id.btnClick ->{
                Toast.makeText(this,"哈哈哈哈",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```
## 默认间隔时间为1500毫秒，可以自行修改，在注解后面添加括号，在括号中声明需要的时间值即可

```
@SingleClick(1000)
override fun onClick(v: View?) {
    if (v != null) {
        when(v.id){
            R.id.btnClick ->{
                 Toast.makeText(this,"呵呵呵呵",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```
## 新增了Kotlin的判断重复的方法，大家可以按照下面的方法直接进行调用，比写注解更加灵活方便：
```
btn.setSingleCLickListener {
            Toast.makeText(this,"啊啊啊啊",Toast.LENGTH_SHORT).show()
        }
```


