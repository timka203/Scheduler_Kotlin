import org.junit.jupiter.api.Assertions
import kotlin.test.Test
import kotlin.test.assertEquals

internal class SchedulerTest
val module1 = Module("test1", 5, 11)
val module2 = Module("test2", 5, 12)
val module3 = Module("test3", 5, 13)
val module4 = Module("test4", 5, 14)
val module5 = Module("test5", 5, 15)
var modulesUnsorted = mutableListOf(module2,module1,module3,module5,module4)
var modulesSorted = mutableListOf(module1,module2,module3,module4,module5)

fun clear()
{
    modulesUnsorted = mutableListOf(module2,module1,module3,module5,module4)
    modulesSorted = mutableListOf(module1,module2,module3,module4,module5)
}
@Test
fun testSchedulerUnsorted() {
    clear()
    val scheduler = Scheduler(20,modulesUnsorted)
    scheduler.schedule()
    val expected = 54
    assertEquals(expected, scheduler.schedule())
}
@Test
fun testSchedulerSorted() {
    clear()
    val scheduler = Scheduler(20,modulesSorted)
    scheduler.schedule()
    val expected = 54
    assertEquals(expected, scheduler.schedule())
}
fun testSchedulerEmpty() {
    clear()
    val scheduler = Scheduler(20, mutableListOf())
    scheduler.schedule()
    val expected = 0
    assertEquals(expected, scheduler.schedule())
}