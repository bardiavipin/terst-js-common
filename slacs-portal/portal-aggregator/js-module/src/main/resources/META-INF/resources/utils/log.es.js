import {_} from 'js-common@1.0.0/bundle';

export default class MainLogger {

    log (msg) {
        console.log("vipin");
        console.log(`${msg} :: ${_.contains([1, 2, 3], 3)}`);
    }
}