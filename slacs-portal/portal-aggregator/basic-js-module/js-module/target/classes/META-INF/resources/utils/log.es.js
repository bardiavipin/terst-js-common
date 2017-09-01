define("js-module@1.0.0/utils/log.es", ["exports", "jquery"], function (exports, _jquery) {
	"use strict";

	Object.defineProperty(exports, "__esModule", {
		value: true
	});

	exports.default = function (msg) {
		(0, _jquery2.default)("#context").append(msg);
	};

	var _jquery2 = _interopRequireDefault(_jquery);

	function _interopRequireDefault(obj) {
		return obj && obj.__esModule ? obj : {
			default: obj
		};
	}
});
//# sourceMappingURL=log.es.js.map