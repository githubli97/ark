import { store } from '/@/store';
import { useRoute } from 'vue-router';

export function hasPermission(code: string) {
  const route = useRoute();
  const menuName = route.meta.code as string;
  const menu = store.state.user.authMenu[menuName] ?? {};
  if (menu) {
    // eslint-disable-next-line no-prototype-builtins
    if (menu.hasOwnProperty('actionCodeList')) {
      const permissions = menu['actionCodeList'];
      return permissions.includes(code);
    }
  }

  return false;
}
