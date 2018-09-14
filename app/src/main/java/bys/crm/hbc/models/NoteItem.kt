package bys.crm.hbc.models

class NoteItem {
    //    public MainActivity.MENU_ITEM getId() {
    //        return id;
    //    }

    var resId: Int = -1
        get() { return field }
        set(value) { field = value }

    var  note: String? = null
        get() { return field }
        set(value) { field = value }
    var  date: String? = null
        get() { return field }
        set(value) { field = value }
    var  time: String? = null
        get() { return field }
        set(value) { field = value }

    constructor() {

    }


    constructor(resId: Int, note: String) {
        //        this.id = itemId;
        this.resId = resId
        this.note = note
    }

    constructor(note: String?, date: String?, time: String?) {
        this.note = note
        this.date = date
        this.time = time
    }


}
