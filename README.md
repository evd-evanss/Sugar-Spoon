# Sugar-Spoon - alpha 1.0.0
![ScreenShot](https://raw.github.com/evd-evanss/sugar-spoon/master/sugar-spoon.png)

## O objetivo deste módulo é otimizar o desenvolvimento de um aplicativo incluindo recursos para tornar o seu código mais limpo, além de que você vai contar com muitos recursos úteis para facilitar o seu dia dia

Principais recursos
- [X] Extensions para Activity, Views, Strings e Float
- [X] Máscaras para Edit texts do tipo: CPF, CNPJ, CEP, DATA, HORA, TELEFONE
- [X] Utils para validar campos de CPF, CNPJ, CEP, DATA, HORA, TELEFONE
- [X] Helper para utilização de login com biometria

## Etapa 1: 
Crie um projeto Android / Pule esta estapa se já estiver criado

## Etapa 2: 
Adicionar o projeto ao sistema de controle de versão (VCS) / Pule para a etapa 4 se seu projeto já tem o controle de versão git

![ScreenShot](https://raw.github.com/evd-evanss/sugar-spoon/master/create_vcs.PNG)

## Etapa 3: 
No menu de controle de versão, adicione todos os arquivos não versionados ao VCS / Pule para a etapa 4 se seu projeto já tem o controle de versão git

![ScreenShot](https://raw.github.com/evd-evanss/sugar-spoon/master/add_files_vcs.PNG)

## Etapa 4: 
No terminal, adicione o submódulo git com "git submodule add https://github.com/evd-evanss/sugar-spoon"

## Etapa 5: 
Vá para File/ProjectStructure/Modules clique em '+' no canto superior esquerdo

![ScreenShot](https://raw.github.com/evd-evanss/sugar-spoon/master/add_module.PNG)

## Etapa 6: 
Selecione ‘Import Gradle Project’

![ScreenShot](https://raw.github.com/evd-evanss/sugar-spoon/master/select_module.PNG)

## Etapa 7: 
Selecione a pasta do submódulo importado 

![ScreenShot](https://raw.github.com/evd-evanss/sugar-spoon/master/select_folder_submodule.PNG)

## Etapa 8: 
Forneça o nome do submódulo -> "SugarSpoon"

## Etapa 9: 
Dentro do arquivo build.gradle(app) inclua "implementation project(':SugarSpoon')" e clique em Sync

![ScreenShot](https://raw.github.com/evd-evanss/sugar-spoon/master/build_gradle.PNG)

## Etapa 10: 
Clique Build/Rebuild Project e pronto!!!




