define("js-module@1.0.0/utils/log.es", ["exports", "js-common@1.0.0/bundle"], function (exports, _bundle) {
    "use strict";

    Object.defineProperty(exports, "__esModule", {
        value: true
    });

    function _classCallCheck(instance, Constructor) {
        if (!(instance instanceof Constructor)) {
            throw new TypeError("Cannot call a class as a function");
        }
    }

    var _createClass = function () {
        function defineProperties(target, props) {
            for (var i = 0; i < props.length; i++) {
                var descriptor = props[i];
                descriptor.enumerable = descriptor.enumerable || false;
                descriptor.configurable = true;
                if ("value" in descriptor) descriptor.writable = true;
                Object.defineProperty(target, descriptor.key, descriptor);
            }
        }

        return function (Constructor, protoProps, staticProps) {
            if (protoProps) defineProperties(Constructor.prototype, protoProps);
            if (staticProps) defineProperties(Constructor, staticProps);
            return Constructor;
        };
    }();

    var MainLogger = function () {
        function MainLogger() {
            _classCallCheck(this, MainLogger);
        }

        _createClass(MainLogger, [{
            key: "log",
            value: function log(msg) {
                console.log("vipin");
                console.log(msg + " :: " + _bundle._.contains([1, 2, 3], 3));
            }
        }]);

        return MainLogger;
    }();

    exports.default = MainLogger;
});
//# sourceMappingURL=log.es.js.map