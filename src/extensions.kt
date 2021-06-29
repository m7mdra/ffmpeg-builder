/**
 * takes a number of any type(int,double,float,..etc) and return a string with abbreviation
 * 100.k  == 100k
 */
var Number.k: String
    get() {
        return "${this}k"
    }
    set(value) {
        this.k = value
    }
var Number.MB: String
    get() {
        return "${this}k"
    }
    set(value) {
        this.MB = value
    }
var Number.GB: String
    get() {
        return "${this}GB"
    }
    set(value) {
        this.GB = value
    }
var Number.T: String
    get() {
        return "${this}T"
    }
    set(value) {
        this.T = value
    }
