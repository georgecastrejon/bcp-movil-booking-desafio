package booking.framework.objects;

import org.openqa.selenium.By;

public class RoomObject {
    public static final By selectRooms = By.id("com.booking:id/select_room_cta");
    public static final By panelResultadosHab = By.id("com.booking:id/rooms_recycler_view");
    public static final By btnSort = By.xpath("//android.widget.TextView[@resource-id=\"com.booking:id/toolbar_item_label\" and @text=\"Sort\"]");
    public static final By totalOptionRoom = By.xpath("//android.widget.FrameLayout[@resource-id=\"com.booking:id/sr_fragment_container\"]//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[./android.view.ViewGroup/android.view.ViewGroup]");
    public static final By selectRoomFirst = By.xpath("(//android.widget.RelativeLayout[@resource-id=\"com.booking:id/room_list_root\"]/android.widget.FrameLayout//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.FrameLayout[@resource-id=\"com.booking:id/room_list_card_wrapper_container\"]//android.widget.LinearLayout[@resource-id=\"com.booking:id/rooms_item_select_layout\"])[position() = 1]");
    public static final By selectRoomFirstTWO = By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.booking:id/list_item\"]//android.widget.LinearLayout[@resource-id=\"com.booking:id/rooms_item_select_layout\"])[position() = 1]");
    public static final By selectRoomFirstThree = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.booking:id/rooms_recycler_view\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout");
    public static final By btnReservar = By.xpath("//android.widget.Button[@resource-id=\"com.booking:id/main_action\"]");
    public static final By panelResultadosHotel = By.xpath("//androidx.recyclerview.widget.RecyclerView");
}