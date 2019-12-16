# EmbeddedRecyclerView
一个可以嵌入scrollerview中使用的recyclerview

### 项目配置

```
  allprojects {
      repositories {
          ...
          maven { url 'https://jitpack.io' }  //添加jitpack仓库
      }
  }
  
  dependencies {
	  implementation 'com.github.bigdongdong:EmbeddedRecyclerView:v1.5' //添加依赖
  }
```


### 使用实例
布局代码：
```xml
<ScrollView
    android:focusable="true"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    
    <!--scroll ContentView-->
   
    <com.cxd.views.moudle.EmbeddedRecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
    </com.cxd.views.moudle.EmbeddedRecyclerView>
</ScrollView>
        

```
java代码（不用setLayoutManager）：
```java
EmbeddedRecyclerView embeddedRecyclerView = findViewbyId(R.id.embeddedRecyclerView);
//通过get()拿到内部的recyclerView
RecyclerView recyclerView = embeddedRecyclerView.get(); 
//操作recyclerView来展示列表
recyclerView.setAdapter(...);


```

### 注意事项
+ EmbeddedRecyclerView不用再setLayoutManager，其内部已经设置好：
```java
EmbeddedRecyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false){
    @Override
    public boolean canScrollVertically() {
        return false ;
    }
});
```
