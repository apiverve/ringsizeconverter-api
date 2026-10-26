from setuptools import setup, find_packages

setup(
    name='apiverve_ringsizeconverter',
    version='1.2.3',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Ring Size Converter translates international ring sizes or millimeter diameters into US and UK standards, inside diameter, and circumference. Paid plans add equivalent sizes for Europe, Japan, Switzerland, and Australia.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/ringsizeconverter?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
