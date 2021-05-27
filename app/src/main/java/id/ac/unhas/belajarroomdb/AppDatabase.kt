package id.ac.unhas.belajarroomdb

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Note::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        private const val DB_NAME = "NOTE_DB"
        private var instance : AppDatabase? = null

        @InternalCoroutinesApi
        fun  geInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room
                        .databaseBuilder(
                            context,
                            AppDatabase::class.java,
                            DB_NAME
                        )
                        .build()
                }
            }
            return instance
        }
    }
}