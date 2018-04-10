package mobile.shows.com.databindingutils

import android.databinding.BaseObservable
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BindableDelegate<T>(
        private var value: T,
        private val indexBR: Int
): ReadWriteProperty<BaseObservable, T> {

    override fun getValue(thisRef: BaseObservable, property: KProperty<*>): T = value

    override fun setValue(thisRef: BaseObservable, property: KProperty<*>, value: T) {
        this.value = value
        thisRef.notifyPropertyChanged(indexBR)
    }
}