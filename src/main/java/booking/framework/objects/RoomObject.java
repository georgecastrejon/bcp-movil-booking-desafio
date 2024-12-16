package booking.framework.objects;

import org.openqa.selenium.By;

public class RoomObject {
    public static final By btnSort = By.xpath("(//android.widget.ImageView[@resource-id='com.booking:id/toolbar_item_icon'])[position() = 1]");
    public static final By secondOptionRoom = By.xpath("(//android.widget.FrameLayout[@resource-id='com.booking:id/results_list_facet']/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup)[position() = 4]");
    public static final By selectRooms = By.id("com.booking:id/select_room_cta");
    public static final By selectRoomFirst = By.xpath("(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.booking:id/rooms_recycler_view\"]//android.widget.LinearLayout[@resource-id=\"com.booking:id/recommended_block_rooms_container\"]/android.widget.LinearLayout)[position() = 1]");
    public static final By selectRoomFirstTWO = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.booking:id/list_item\"]//android.widget.LinearLayout[@resource-id=\"com.booking:id/rooms_item_select_layout\"]");
    public static final By btnReservar = By.xpath("(//android.widget.Button[@resource-id='com.booking:id/main_action'])[position() = 1]");
}