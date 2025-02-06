# 1. git pull 문제

### 상황

git pull을 시도

### 문제

오류 발생

```
-> git pull origin main
From https://github.com/100-hours-a-week/2-jelly-song
* branch            main       -> FETCH_HEAD
  hint: You have divergent branches and need to specify how to reconcile them.
  hint: You can do so by running one of the following commands sometime before
  hint: your next pull:
  hint:
  hint:   git config pull.rebase false  # merge
  hint:   git config pull.rebase true   # rebase
  hint:   git config pull.ff only       # fast-forward only
  hint:
  hint: You can replace "git config" with "git config --global" to set a default
  hint: preference for all repositories. You can also pass --rebase, --no-rebase,
  hint: or --ff-only on the command line to override the configured default per
  hint: invocation.
  fatal: Need to specify how to reconcile divergent branches.
```

### 해결
git pull --rebase origin main을 타이핑
```
git pull --rebase origin main
From https://github.com/100-hours-a-week/2-jelly-song
* branch            main       -> FETCH_HEAD
  Successfully rebased and updated refs/heads/main.
```

### 이유

1. github 상에서 md파일을 수정한 이력이 있는 상황
2. pull을 하지 않고 수정해서 충돌이 일어남
3. 동기화가 필요해서 나타난 문제

### 개념

#### 위의 명령어 작동 순서
1. 원격(origin/main)의 최신 커밋을 가져옴 (fetch)
2. 내 로컬 브랜치(main)의 변경 사항을 잠시 따로 저장해둠 (stash와 비슷)
3. 원격 브랜치(origin/main)의 최신 커밋을 내 로컬 main 브랜치에 적용
4. 저장해둔 내 변경 사항을 원격 변경 사항 위에 다시 적용

#### ++ rebase vs merge 개념

1. Git에서 한 브랜치에서 다른 브랜치로 합치는 방법은 Merge와 Rebase다.
2. Merge와 Rebase의 실행결과는 같지만 커밋 히스토리가 달라진다.
3. Merge는 쉽고 안전하지만 커밋히스토리가 지저분할 수 있다 반면 Rebase는 잘 모르고 사용할 경우 위험할 수 있어 까다롭지만 커밋히스토리를 깔끔하게 관리할 수 있다.
4. Rebase는 base를 새롭게 설정한다는 의미로 이해하면 좋다.
