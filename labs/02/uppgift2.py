def get_initials(full_name):
    alpha_name = full_name.replace("-", " ")
    names = alpha_name.rsplit()
    initials = ""
    for name in names:
        initials += name[0].capitalize() + "."
    return initials



