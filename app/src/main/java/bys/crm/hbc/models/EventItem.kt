package bys.crm.hbc.models

class EventItem {
    //    public MainActivity.MENU_ITEM getId() {
    //        return id;
    //    }

    var resId: Int = -1
        get() { return field }
        set(value) { field = value }

    var  status: String? = null
        get() { return field }
        set(value) { field = value }
    var  title: String? = null
        get() { return field }
        set(value) { field = value }
    var  start: String? = null
        get() { return field }
        set(value) { field = value }
    var  end: String? = null
        get() { return field }
        set(value) { field = value }


    constructor() {

    }


    constructor(resId: Int, status: String) {
        //        this.id = itemId;
        this.resId = resId
        this.status = status
    }

    constructor(status: String?, title: String?, start: String?, end: String?) {
        this.status = status
        this.title = title
        this.start = start
        this.end = end
    }

    constructor(title: String?, start: String?, end: String?) {
        this.title = title
        this.start = start
        this.end = end
    }


}
