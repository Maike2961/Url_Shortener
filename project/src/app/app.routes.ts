import { Routes } from '@angular/router';
import { LayoutPageComponent } from './pages/layout-page/layout-page.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'url-shorter',
        pathMatch: 'full'
    },
    {
        path: 'url-shorter',
        component: LayoutPageComponent
    },
];
