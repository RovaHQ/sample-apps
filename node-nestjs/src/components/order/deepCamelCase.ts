import * as _ from 'lodash';

export const camelCase = (object) => {
  const camelCaseObject = {};
  _.forEach(
    object,
    (value, key) => {
      if (_.isPlainObject(value) || _.isArray(value)) {
        value = camelCase(value);
      }
      camelCaseObject[_.camelCase(key)] = value;
    },
  );
  return camelCaseObject;
};
