import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RoutingModule } from './routing.module';
import { FormsModule } from '@angular/forms';

//for pokemon example
import { HttpClientModule } from '@angular/common/http';
//
import { AppComponent } from './app.component';
import { AccessComponent } from './components/access/access.component';
import { ClassComponent } from './components/class/class.component';
import { CliComponent } from './components/cli/cli.component';
import { ComponentComponent } from './components/component/component.component';
import { DatabindingComponent } from './components/databinding/databinding.component';
import { DecoratorComponent } from './components/decorator/decorator.component';
import { DirectiveComponent } from './components/directive/directive.component';
import { HttpComponent } from './components/http/http.component';
import { MainComponent } from './components/main/main.component';
import { ModuleComponent } from './components/module/module.component';
import { NavComponent } from './components/nav/nav.component';
import { NpmComponent } from './components/npm/npm.component';
import { PackageComponent } from './components/package/package.component';
import { PipeComponent } from './components/pipe/pipe.component';
import { RoutingComponent } from './components/routing/routing.component';
import { ServiceComponent } from './components/service/service.component';
import { StructuralComponent } from './components/structural/structural.component';
import { TemplateComponent } from './components/template/template.component';
import { TypesComponent } from './components/types/types.component';
import { TypeScriptComponent } from './components/typescript/typescript.component';
import { FlashcardComponent } from './components/structural/flashcard/flashcard.component';
import { PokemonService } from './services/pokemon.service';
import { DiComponent } from './components/di/di.component';

@NgModule({
  declarations: [
    AppComponent,
    AccessComponent,
    ClassComponent,
    CliComponent,
    ComponentComponent,
    DatabindingComponent,
    DecoratorComponent,
    DirectiveComponent,
    HttpComponent,
    MainComponent,
    ModuleComponent,
    NavComponent,
    NpmComponent,
    PackageComponent,
    PipeComponent,
    RoutingComponent,
    ServiceComponent,
    StructuralComponent,
    TemplateComponent,
    TypesComponent,
    TypeScriptComponent,
    FlashcardComponent,
    DiComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RoutingModule,
    FormsModule
  ],
  providers: [PokemonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
