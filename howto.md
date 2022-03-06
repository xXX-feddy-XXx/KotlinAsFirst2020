git clone https://github.com/xXX-feddy-XXx/KotlinAsFirst2020.git  
cd KotlinAsFirst2020  
git remote add upstream-my https://github.com/xXX-feddy-XXx/KotlinAsFirst2021.git  
get fetch upstream-my  
git checkout -b backport  
git cherry-pick d535f359...FETCH_HEAD  
git remote add upstream-theirs https://github.com/sql3/KotlinAsFirst2021.git  
git fetch upstream-theirs/mater  
git merge backport upstream-theirs/mater  
разрешаем конфликты  
git remote -v > remotes  
создаем файл howto.md  
git add .  
git commit 
git push  
