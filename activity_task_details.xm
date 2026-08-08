```xml
<?xml version="1.0" encoding="utf-8"?>

<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="20dp">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Task Details"
            android:textSize="28sp"
            android:textStyle="bold"
            android:gravity="center"
            android:padding="15dp" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Task Title"
            android:textSize="18sp"
            android:textStyle="bold"
            android:layout_marginTop="20dp" />

        <TextView
            android:id="@+id/txtTaskTitle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="22sp"
            android:padding="10dp" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Description"
            android:textSize="18sp"
            android:textStyle="bold"
            android:layout_marginTop="15dp" />

        <TextView
            android:id="@+id/txtTaskDescription"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:padding="10dp" />

        <TextView
            android:id="@+id/txtTaskPriority"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:textStyle="bold"
            android:padding="10dp"
            android:layout_marginTop="15dp" />

        <TextView
            android:id="@+id/txtTaskDate"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:textStyle="bold"
            android:padding="10dp" />

        <Button
            android:id="@+id/btnBack"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Back"
            android:textSize="18sp"
            android:layout_marginTop="25dp" />

    </LinearLayout>

</ScrollView>
```
